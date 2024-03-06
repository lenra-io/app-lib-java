package io.lenra.app;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.lenra.api.AppRequest;
import io.lenra.api.ListenerRequest;
import io.lenra.api.Manifest;
import io.lenra.api.ResourceRequest;
import io.lenra.api.ViewRequest;
import jakarta.inject.Inject;

public abstract class LenraApplication {
	@Inject
	private RequestHandler requestHandler;
	private final Manifest manifest;

	public LenraApplication() {
		this.manifest = manifest();
	}

	public Manifest getManifest() {
		return manifest;
	}

	abstract protected Manifest manifest();

	final public Object handle(AppRequest request) {
		if (request instanceof ViewRequest) {
			return requestHandler.handleView((ViewRequest) request);
			// return handle((ViewRequest) request);
		} else if (request instanceof ListenerRequest) {
			return handle((ListenerRequest) request);
		} else if (request instanceof ResourceRequest) {
			return handle((ResourceRequest) request);
		} else {
			return manifest;
		}
	}

	// private Object handle(ViewRequest request) {
	// 	var view = request.getView();
	// 	System.out.println("Handling view request: " + view);
	// 	var handler = viewsNew.get(view);
	// 	if (handler == null) {
	// 		throw new NullPointerException("View not found: " + view);
	// 	}
	// 	System.out.println("Handler: " + handler);
	// 	System.out.println("Handler class: " + handler.getClass());
	// 	Type[] interfaces = handler.getClass().getGenericInterfaces();
	// 	Type superClass = handler.getClass().getGenericSuperclass();
	// 	System.out.println("Handler superClass: " + superClass);
	// 	System.out.println("Handler interfaces: " + java.util.List.of(interfaces));
	// 	// if (superClass instanceof Class<?>) { // sanity check, should never happen
	// 	// 	throw new IllegalArgumentException("Internal error: ViewHandler constructed without actual type information");
	// 	// }
	// 	// Type[] typeArgs = ((java.lang.reflect.ParameterizedType) superClass).getActualTypeArguments();
	// 	System.out.println("Request interface: " + interfaces[0]);
	// 	Type[] typeArgs = ((java.lang.reflect.ParameterizedType) interfaces[0]).getActualTypeArguments();
	// 	System.out.println("Type args: " + typeArgs[0] + ", " + typeArgs[1]);
	// 	// var data = mapper.convertValue(request.getData(), handler.dataType);
	// 	// var props = mapper.convertValue(request.getProps(), handler.propsType);
	// 	// System.out.println("Data: " + data);
	// 	// System.out.println("Props: " + props);
	// 	return request;
	// }

	// private Object handle(ListenerRequest request) {
	// 	var listener = request.getListener();
	// 	System.out.println("Handling listener request: " + listener);
	// 	var handler = listeners.get(request.getListener());
	// 	if (handler == null) {
	// 		throw new NullPointerException("Listener not found: " + listener);
	// 	}
	// 	var props = mapper.convertValue(request.getProps(), handler.propsType);
	// 	System.out.println("Props: " + props);
	// 	return request;
	// }

	private Object handle(ResourceRequest request) {
		var resource = request.getResource();
		System.out.println("Handling resource request: " + resource);
		return request;
	}
}
