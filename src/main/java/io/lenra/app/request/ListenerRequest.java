package io.lenra.app.request;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import io.lenra.app.LenraApplication;
import io.lenra.app.ListenerHandler;
import io.lenra.app.classes.Api;
import lombok.Getter;

@JsonDeserialize(using = ListenerRequest.ListenerRequestDeserializer.class)
public class ListenerRequest<P> extends AppRequest<Object> {
    @JsonProperty(required = true)
    private String listener;
    @Getter
    private P props;

    private ListenerHandler<P> handler;

    @Getter
    private Api api;

    ListenerRequest(String listener, ListenerHandler<P> handler, P props, Api api) {
        this.listener = listener;
        this.handler = handler;
        this.props = props;
        this.api = api;
    }

    @Override
    public Object handle(LenraApplication application) {
        return handler.handle(this);
    }

    @Component
    public static class ListenerRequestDeserializer extends StdDeserializer<ListenerRequest<?>> {
        @Autowired
        private LenraApplication app;
        @Autowired
        private ObjectMapper mapper;

        public ListenerRequestDeserializer() {
            super(ListenerRequest.class);
        }

        @Override
        @SuppressWarnings({ "unchecked", "rawtypes" })
        public ListenerRequest<?> deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException, JacksonException {
            JsonNode node = p.getCodec().readTree(p);

            String listener = node.get("listener").asText();

            var handler = app.getListeners().get(listener);
            if (handler == null) {
                throw new NullPointerException("Listener not found: " + listener);
            }

            var props = mapper.convertValue(node.get("props"), handler.propsType);
            var api = mapper.convertValue(node.get("api"), Api.class);
            return new ListenerRequest(listener, handler, props, api);
        }
    }
}
