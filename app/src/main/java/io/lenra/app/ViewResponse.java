package io.lenra.app;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import io.lenra.app.components.LenraComponent;
import io.lenra.app.responses.json_view.definitions.JsonObject;

@JsonTypeInfo(use = Id.DEDUCTION, defaultImpl = JsonObject.class)
@JsonSubTypes({ @Type(LenraComponent.class), @Type(JsonObject.class) })
public interface ViewResponse {
}
