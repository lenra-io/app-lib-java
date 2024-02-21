package io.lenra.app.handlers;

import java.lang.reflect.Type;
import java.util.function.Function;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.lenra.app.request.ListenerRequest;


public abstract class ListenerHandler<P> {
    private static final ObjectMapper mapper = new ObjectMapper();
    public final JavaType propsType;
    public final Function<ListenerRequest<P>, Object> handler;
    public ListenerHandler(Function<ListenerRequest<P>, Object> handler) {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class<?>) { // sanity check, should never happen
            throw new IllegalArgumentException("Internal error: ListenerHandler constructed without actual type information");
        }
        Type[] typeArgs = ((java.lang.reflect.ParameterizedType) superClass).getActualTypeArguments();
        this.propsType = mapper.constructType(typeArgs[0]);
        this.handler = handler;
    }

    public Object handle(ListenerRequest<P> request) {
        return handler.apply(request);
    }
}