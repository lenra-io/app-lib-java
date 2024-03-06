package io.lenra.app.annotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ExecutableType;
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
		for (TypeElement annotation : annotations) {
			System.out.println("Annotation: " + annotation.getQualifiedName());
			var annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);
			var views = annotatedElements.stream().map(element -> {
				ExecutableElement method = (ExecutableElement) element;
				var viewAnnotation = method.getAnnotation(View.class);
				String viewName = viewAnnotation.name();
				// TODO: manage package name ? Or an annotation for name prefix
				if (viewName.isEmpty()) {
					viewName = method.getSimpleName().toString();
				}
				System.out.println("Method: " + element.getSimpleName() + " [" + element.getClass() + "]");
				var parameters = method.getParameters();
				System.out.println("parameters: " + parameters);
				var viewParameters = new ArrayList<ViewParameter>();
				ViewParameterType lastType = null;
				for (int i = 0; i < parameters.size(); i++) {
					var param = parameters.get(i);
					System.out.println("Parameter: " + param.getSimpleName() + " [" + param.getClass() + "]");
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

					var parameter = ViewParameter.parse(type, param);
					viewParameters.add(parameter);
					lastType = type;
				};

				String methodFullName = processingEnv.getElementUtils().getBinaryName((TypeElement)method.getEnclosingElement()) + "." + method.getSimpleName();

				return new ViewRef(viewName, methodFullName, viewParameters);
			}).collect(Collectors.toList());
			Map<String, ViewRef> viewMap = views.stream().collect(Collectors.toMap(ViewRef::getName, view -> view));

			try {
				this.writeAppViewsClass(viewMap);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	private void writeAppViewsClass(Map<String, ViewRef> views) throws IOException {
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
			out.println();

			out.println("@Named");
			out.print("public class ");
			out.print(className);
			out.println(" extends RequestHandler {");
			out.println();

			out.println(" public Object handleView(ViewRequest request) {");
			out.println("   System.out.println(\"Handling view request: \" + request.getView());");
			out.println("   return request;");
			// TODO: manage the call of the views
			out.println("   var view = request.getView();");
			out.println("   switch (view) {");
			views.values().forEach(view -> {
				out.println("     case \"" + view.getName() + "\":");
				out.print("       return " + view.getMethod() + "(");
				for (var i = 0; i < view.getParameters().size(); i++) {
					var parameter = view.getParameters().get(i);
					out.print("request.get");
					out.print(parameter.getType().name().substring(0, 1).toUpperCase());
					out.print(parameter.getType().name().substring(1).toLowerCase());
					out.print("()");
					if (i < view.getParameters().size() - 1) {
						out.print(", ");
					}
				}
				out.println(");");
			});
			out.println("     default:");
			out.println("       throw new IllegalArgumentException(\"Unknown view: \" + view);");
			out.println("   }");
			out.println(" }");
			out.println();

			// out.print(" public ");
			// out.print(simpleClassName);
			// out.println(" build() {");
			// out.println(" return object;");
			// out.println(" }");
			// out.println();

			// setterMap.entrySet().forEach(setter -> {
			// String methodName = setter.getKey();
			// String argumentType = setter.getValue();

			// out.print(" public ");
			// out.print(builderSimpleClassName);
			// out.print(" ");
			// out.print(methodName);

			// out.print("(");

			// out.print(argumentType);
			// out.println(" value) {");
			// out.print(" object.");
			// out.print(methodName);
			// out.println("(value);");
			// out.println(" return this;");
			// out.println(" }");
			// out.println();
			// });

			out.println("}");
		}
	}

	@AllArgsConstructor
	@Data
	private static class ViewRef {
		private String name;
		private String method;
		private List<ViewParameter> parameters;
	}

	@AllArgsConstructor
	@Data
	private static class ViewParameter {
		private ViewParameterType type;
		private String className;

		public static ViewParameter parse(ViewParameterType type, VariableElement element) {
			return new ViewParameter(type, element.asType().toString());
		}
	}

	private static enum ViewParameterType {
		DATA, PROPS, CONTEXT
	}
}
