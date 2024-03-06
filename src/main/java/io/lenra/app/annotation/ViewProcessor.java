package io.lenra.app.annotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.JavaFileObject;

import com.google.auto.service.AutoService;

import lombok.AllArgsConstructor;
import lombok.Data;

@SupportedAnnotationTypes("io.lenra.app.annotation.View")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
@AutoService(Processor.class)
public class ViewProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		Map<String, MethodRef<ViewParameterType>> views = new HashMap<>();
		// Map<String, ListenerRef> listeners = new HashMap<>();
		// Map<String, ResourceRef> resources = new HashMap<>();

		for (TypeElement annotation : annotations) {
			System.out.println("Annotation: " + annotation.getQualifiedName());
			var annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
			annotatedElements.forEach(element -> {
				ExecutableElement method = (ExecutableElement) element;
				var viewAnnotation = method.getAnnotation(View.class);
				String name = viewAnnotation.name();
				// TODO: manage package name ? Or an annotation for name prefix
				if (name.isEmpty()) {
					name = method.getSimpleName().toString();
				}
				var parameters = method.getParameters();
				var viewParameters = new ArrayList<Parameter<ViewParameterType>>();
				ViewParameterType lastType = null;
				for (int i = 0; i < parameters.size(); i++) {
					var param = parameters.get(i);
					// determine parameter type with position and annotation
					ViewParameterType type = ViewParameterType.DATA;
					if (param.getAnnotation(View.Data.class) != null) {
						type = ViewParameterType.DATA;
					} else if (param.getAnnotation(View.Props.class) != null) {
						type = ViewParameterType.PROPS;
					} else if (param.getAnnotation(View.Context.class) != null) {
						type = ViewParameterType.CONTEXT;
					} else {
						if (lastType != null) {
							switch (lastType) {
								case DATA:
									type = ViewParameterType.PROPS;
									break;
								case PROPS:
									type = ViewParameterType.CONTEXT;
									break;
								case CONTEXT:
									throw new IllegalArgumentException("Too many parameters");
							}
						}
					}
					// check if there is more than one parameter of the same type
					final var finalType = type;
					if (viewParameters.stream().anyMatch(p -> p.getType() == finalType)) {
						throw new IllegalArgumentException("Too many parameters of type " + type);
					}

					var parameter = Parameter.parse(type, param);
					viewParameters.add(parameter);
					lastType = type;
				}
				;

				String methodFullName = processingEnv.getElementUtils()
						.getBinaryName((TypeElement) method.getEnclosingElement()) + "." + method.getSimpleName();

				var view = new MethodRef<>(name, methodFullName, viewParameters);
				if (views.containsKey(name)) {
					throw new IllegalArgumentException("View " + name + " already exists");
				}
				views.put(name, view);
			});
		}

		try {
			this.writeRequestHandlerClass(views);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void writeRequestHandlerClass(Map<String, MethodRef<ViewParameterType>> views) throws IOException {
		String packageName = "io.lenra.app";
		String className = "RequestHandlerImpl";

		JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(packageName + "." + className);

		try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {

			out.print("package ");
			out.print(packageName);
			out.println(";");
			out.println();

			out.println("import io.lenra.api.ViewRequest;");
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

			out.println(" @Override");
			out.println(" public Object handleView(ViewRequest request) {");
			out.println("   var name = request.getView();");
			writeRequestHandlers(out, views);
			out.println(" }");
			out.println();

			out.println("}");
		}
	}

	private <T extends Enum<T>> void writeRequestHandlers(PrintWriter out, Map<String, MethodRef<T>> handlers)
			throws IOException {
		out.println("   System.out.println(\"Handling \" + request.getClass().getSimpleName() + \" : \" + name);");
		// manage the call of the views
		out.println("   switch (name) {");
		handlers.values().forEach(view -> {
			out.println("     case \"" + view.getName() + "\":");
			out.println("       return " + view.getMethod() + "(");
			for (var i = 0; i < view.getParameters().size(); i++) {
				var parameter = view.getParameters().get(i);
				// mapper.convertValue(, new TypeReference<List<MyDto>>() { })
				out.print("       mapper.convertValue(");
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
		});
		out.println("     default:");
		out.println("       throw new IllegalArgumentException(\"Unknown view: \" + view);");
		out.println("   }");
	}

	@AllArgsConstructor
	@Data
	private static class MethodRef<T extends Enum<T>> {
		private String name;
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

	private static enum ViewParameterType {
		DATA, PROPS, CONTEXT
	}
}
