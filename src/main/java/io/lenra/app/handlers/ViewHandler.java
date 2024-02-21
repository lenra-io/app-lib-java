package io.lenra.app.handlers;

import java.lang.reflect.Type;
import java.util.function.Function;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.lenra.app.request.ViewRequest;


public abstract class ViewHandler<D, P> {
    private static final ObjectMapper mapper = new ObjectMapper();
    public final JavaType dataType;
    public final JavaType propsType;
    public final Function<ViewRequest<D, P>, Object> handler;
    public ViewHandler(Function<ViewRequest<D, P>, Object> handler) {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class<?>) { // sanity check, should never happen
            throw new IllegalArgumentException("Internal error: ViewHandler constructed without actual type information");
        }
        Type[] typeArgs = ((java.lang.reflect.ParameterizedType) superClass).getActualTypeArguments();
        this.dataType = mapper.constructType(typeArgs[0]);
        this.propsType = mapper.constructType(typeArgs[1]);
        this.handler = handler;
    }

    public Object handle(ViewRequest<D, P> request) {
        return handler.apply(request);
    }

    public static interface DataMapper<T> {
        public T map(ObjectMapper mapper, Object data);
    }

    public static class JavaTypeDataMapper<T> implements DataMapper<T> {
        public final JavaType type;
        public JavaTypeDataMapper(JavaType type) {
            this.type = type;
        }
        public T map(ObjectMapper mapper, Object data) {
            return mapper.convertValue(data, type);
        }
    }

    public static class TypeReferenceDataMapper<T> implements DataMapper<T> {
        public final TypeReference<T> type;
        public TypeReferenceDataMapper(TypeReference<T> type) {
            this.type = type;
        }
        public T map(ObjectMapper mapper, Object data) {
            return mapper.convertValue(data, type);
        }
    }
}