package io.lenra.app.annotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.JavaFileObject;

import com.google.auto.service.AutoService;

import lombok.AllArgsConstructor;
import lombok.Data;

@SupportedAnnotationTypes({ "io.lenra.app.annotation.Manifest", "io.lenra.app.annotation.View",
		"io.lenra.app.annotation.Listener" })
@SupportedSourceVersion(SourceVersion.RELEASE_17)
@AutoService(Processor.class)
public class AppProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		String manifestClass = null;
		Map<String, MethodRef<ViewParameter>> views = new HashMap<>();
		Map<String, MethodRef<ListenerParameter>> listeners = new HashMap<>();
		// TODO: manage resources
		// Map<String, ResourceRef> resources = new HashMap<>();

		for (TypeElement annotation : annotations) {
			var annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
			if (annotation.getQualifiedName().toString().equals(Manifest.class.getName())) {
				if (annotatedElements.size() > 1) {
					throw new IllegalArgumentException("Too many manifests");
				}
				if (annotatedElements.isEmpty()) {
					throw new IllegalArgumentException("No manifest");
				}
				manifestClass = processingEnv.getElementUtils()
						.getBinaryName((TypeElement) annotatedElements.iterator().next()).toString();

			} else if (annotation.getQualifiedName().toString().equals(View.class.getName())) {
				parseMethods(views, ViewParameter.class, View.class, View::name, annotatedElements);
			} else if (annotation.getQualifiedName().toString().equals(Listener.class.getName())) {
				parseMethods(listeners, ListenerParameter.class, Listener.class, Listener::name, annotatedElements);
			} else {
				throw new IllegalArgumentException("Unknown annotation: " + annotation.getQualifiedName());
			}
		}

		try {
			this.writeRequestHandlerClass(manifestClass, views, listeners);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private <A extends Annotation, T extends Enum<T> & AnnotatedParameter> void parseMethods(
			Map<String, MethodRef<T>> elements, Class<T> enumClass, Class<A> annotationClass, Function<A, String> nameGetter,
			Set<? extends Element> methods) {
		methods.forEach(element -> {
			ExecutableElement method = (ExecutableElement) element;
			parseMethod(elements, enumClass, annotationClass, nameGetter, method);
		});
	}

	private <A extends Annotation, T extends Enum<T> & AnnotatedParameter> void parseMethod(
			Map<String, MethodRef<T>> elements, Class<T> enumClass, Class<A> annotationClass, Function<A, String> nameGetter,
			ExecutableElement method) {
		String name = "";
		var annotation = method.getAnnotation(annotationClass);
		if (annotation != null) {
			name = nameGetter.apply(annotation);
		}
		// TODO: manage package name ? Or an annotation for name prefix
		if (name.isEmpty()) {
			name = method.getSimpleName().toString();
		}
		var parameters = parseParameters(enumClass, method.getParameters());

		String methodFullName = processingEnv.getElementUtils()
				.getBinaryName((TypeElement) method.getEnclosingElement()) + "." + method.getSimpleName();

		var element = new MethodRef<>(methodFullName, parameters);
		if (elements.containsKey(name)) {
			throw new IllegalArgumentException("View " + name + " already exists");
		}
		elements.put(name, element);
	}

	private <T extends Enum<T> & AnnotatedParameter> List<Parameter<T>> parseParameters(Class<T> enumClass,
			List<? extends VariableElement> parameters) {
		var parsedParameters = new ArrayList<Parameter<T>>();
		// determine parameter type with position and annotation
		var values = List.of(enumClass.getEnumConstants());
		var notAddedParam = new ArrayList<>(values);
		for (int i = 0; i < parameters.size(); i++) {
			var param = parameters.get(i);
			T type = null;
			for (T t : values) {
				if (param.getAnnotation(t.annotation()) != null) {
					type = t;
					break;
				}
			}
			if (type == null) {
				if (notAddedParam.isEmpty()) {
					throw new IllegalArgumentException("Too many parameters");
				}
				type = notAddedParam.get(0);
			}
			// check if there is more than one parameter of the same type
			if (!notAddedParam.remove(type)) {
				throw new IllegalArgumentException("Too many parameters of type " + type);
			}

			var parameter = Parameter.parse(type, param);
			parsedParameters.add(parameter);
		}
		return parsedParameters;
	}

	private void writeRequestHandlerClass(String manifestClass, Map<String, MethodRef<ViewParameter>> views,
			Map<String, MethodRef<ListenerParameter>> listeners) throws IOException {
		String packageName = "io.lenra.app";
		String className = "RequestHandlerImpl";

		JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(packageName + "." + className);
		builderFile.delete();

		try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {

			out.print("package ");
			out.print(packageName);
			out.println(";");
			out.println();

			out.println("import io.lenra.api.ViewRequest;");
			out.println("import io.lenra.api.ListenerRequest;");
			out.println("import io.lenra.app.exception.NotFoundException;");
			out.println("import jakarta.inject.Named;");
			out.println("import jakarta.inject.Inject;");
			out.println("import com.fasterxml.jackson.databind.ObjectMapper;");
			out.println("import com.fasterxml.jackson.core.type.TypeReference;");
			out.println();

			out.println("@Named");
			out.print("public class ");
			out.print(className);
			out.println(" extends RequestHandler {");
			out.println();

			out.println(" @Inject");
			out.println(" private ObjectMapper mapper;");

			out.println(" private " + manifestClass + " manifest = new " + manifestClass + "();");
			out.println();

			out.println(" @Override");
			out.println(" public io.lenra.api.Manifest handleManifest() {");
			out.println("   return manifest;");
			out.println(" }");
			out.println();

			out.println(" @Override");
			out.println(" public Object handleView(ViewRequest request) {");
			out.println("   var name = request.getView();");
			writeRequestHandlers(out, views, true);
			out.println(" }");
			out.println();

			out.println(" @Override");
			out.println(" public void handleListener(ListenerRequest request) {");
			out.println("   var name = request.getListener();");
			writeRequestHandlers(out, listeners, false);
			out.println(" }");
			out.println();

			out.println("}");
		}
	}

	private <T extends Enum<T>> void writeRequestHandlers(PrintWriter out, Map<String, MethodRef<T>> handlers,
			boolean returns)
			throws IOException {
		out.println("   System.out.println(\"Handling \" + request.getClass().getSimpleName() + \" : \" + name);");
		// manage the call of the views
		out.println("   switch (name) {");
		handlers.entrySet().forEach(entry -> {
			var name = entry.getKey();
			var view = entry.getValue();
			out.println("     case \"" + name + "\":");
			out.print("       ");
			if (returns)
				out.print("return ");
			out.println(view.getMethod() + "(");
			for (var i = 0; i < view.getParameters().size(); i++) {
				var parameter = view.getParameters().get(i);
				// mapper.convertValue(, new TypeReference<List<MyDto>>() { })
				out.print("         mapper.convertValue(");
				out.print("request.get");
				out.print(parameter.getType().name().substring(0, 1).toUpperCase());
				out.print(parameter.getType().name().substring(1).toLowerCase());
				out.print("(), new TypeReference<");
				out.print(parameter.getClassName());
				out.print(">() { })");
				if (i < view.getParameters().size() - 1) {
					out.print(",");
				}
				out.println();
			}
			out.println("			 );");
			if (!returns)
				out.println("       break;");
		});
		out.println("     default:");
		out.println("       throw new NotFoundException(\"Unknown element: \" + name);");
		out.println("   }");
	}

	@AllArgsConstructor
	@Data
	private static class MethodRef<T extends Enum<T>> {
		// private String name;
		private String method;
		private List<Parameter<T>> parameters;
	}

	@AllArgsConstructor
	@Data
	private static class Parameter<T extends Enum<T>> {
		private T type;
		private String className;

		public static <T extends Enum<T>> Parameter<T> parse(T type, VariableElement element) {
			return new Parameter<>(type, element.asType().toString());
		}
	}

	private static interface AnnotatedParameter {
		<A extends Annotation> Class<A> annotation();
	}

	private static enum ViewParameter implements AnnotatedParameter {
		DATA(View.Data.class), PROPS(View.Props.class), CONTEXT(View.Context.class);

		private final Class<? extends Annotation> annotation;

		<A extends Annotation> ViewParameter(Class<A> annotation) {
			this.annotation = annotation;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Class<? extends Annotation> annotation() {
			return this.annotation;
		}
	}

	private static enum ListenerParameter implements AnnotatedParameter {
		PROPS(Listener.Props.class), API(Listener.Api.class);

		private final Class<? extends Annotation> annotation;

		<A extends Annotation> ListenerParameter(Class<A> annotation) {
			this.annotation = annotation;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Class<? extends Annotation> annotation() {
			return this.annotation;
		}
	}
}