package io.lenra.app;

import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.lenra.api.AppRequest;
import io.lenra.api.ListenerRequest;
import io.lenra.api.Manifest;
import io.lenra.api.ResourceRequest;
import io.lenra.api.ViewRequest;
import io.lenra.app.handlers.ListenerHandler;
import io.lenra.app.handlers.ViewHandler;
import jakarta.inject.Inject;

public abstract class LenraApplication {
    @Inject
    private ObjectMapper mapper;
    private final Manifest manifest;
    private final Map<String, ViewHandler<?, ?>> views;
    private final Map<String, ListenerHandler<?>> listeners;

    public LenraApplication() {
        this.manifest = manifest();
        this.views = Collections.unmodifiableMap(views());
        this.listeners = Collections.unmodifiableMap(listeners());
    }

    public Manifest getManifest() {
        return manifest;
    }

    public Map<String, ViewHandler<?, ?>> getViews() {
        return views;
    }

    public Map<String, ListenerHandler<?>> getListeners() {
        return listeners;
    }

    abstract protected Manifest manifest();

    abstract protected Map<String, ViewHandler<?, ?>> views();

    abstract protected Map<String, ListenerHandler<?>> listeners();

    final public Object handle(AppRequest request) {
        if (request instanceof ViewRequest) {
            return handle((ViewRequest) request);
        } else if (request instanceof ListenerRequest) {
            return handle((ListenerRequest) request);
        } else if (request instanceof ResourceRequest) {
            return handle((ResourceRequest) request);
        } else {
            return manifest;
        }
    }

    private Object handle(ViewRequest request) {
        var view = request.getView();
        System.out.println("Handling view request: " + view);
        var handler = views.get(request.getView());
        if (handler == null) {
            throw new NullPointerException("View not found: " + view);
        }
        var data = mapper.convertValue(request.getData(), handler.dataType);
        var props = mapper.convertValue(request.getProps(), handler.propsType);
        System.out.println("Data: " + data);
        System.out.println("Props: " + props);
        return request;
    }

    private Object handle(ListenerRequest request) {
        var listener = request.getListener();
        System.out.println("Handling listener request: " + listener);
        var handler = listeners.get(request.getListener());
        if (handler == null) {
            throw new NullPointerException("Listener not found: " + listener);
        }
        var props = mapper.convertValue(request.getProps(), handler.propsType);
        System.out.println("Props: " + props);
        return request;
    }

    private Object handle(ResourceRequest request) {
        var resource = request.getResource();
        System.out.println("Handling resource request: " + resource);
        return request;
    }
}
