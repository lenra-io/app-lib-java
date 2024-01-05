package io.lenra.applibjava.request;

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

import io.lenra.applibjava.LenraApplication;
import io.lenra.applibjava.ViewHandler;
import lombok.Getter;

@JsonDeserialize(using = ViewRequest.ViewRequestDeserializer.class)
public class ViewRequest<D, P> extends AppRequest<Object> {
    @JsonProperty(required = true)
    private String view;
    private ViewHandler<D, P> handler;
    @Getter
    private D data;
    @Getter
    private P props;

    ViewRequest(String view, ViewHandler<D, P> handler, D data, P props) {
        this.view = view;
        this.handler = handler;
        this.data = data;
        this.props = props;
    }

    @Override
    public Object handle(LenraApplication application) {
        return handler.handle(this);
    }

    @Component
    public static class ViewRequestDeserializer extends StdDeserializer<ViewRequest<?, ?>> {
        @Autowired
        private LenraApplication app;
        @Autowired
        private ObjectMapper mapper;

        public ViewRequestDeserializer() {
            super(ViewRequest.class);
        }

        @Override
        @SuppressWarnings({ "unchecked", "rawtypes" })
        public ViewRequest<?, ?> deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException, JacksonException {
            JsonNode node = p.getCodec().readTree(p);
            String view = node.get("view").asText();
            var handler = app.getViews().get(view);
            if (handler == null) {
                throw new NullPointerException("View not found: " + view);
            }
            var data = mapper.convertValue(node.get("data"), handler.dataType);
            var props = mapper.convertValue(node.get("props"), handler.propsType);
            return new ViewRequest(view, handler, data, props);
        }
    }
}
