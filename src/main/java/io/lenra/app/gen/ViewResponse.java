package io.lenra.app.gen;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import io.lenra.app.gen.components.LenraComponent;
import io.lenra.app.gen.json-view.definitions.JsonObject;

@JsonSubTypes({ @Type(LenraComponent.class), @Type(JsonObject.class) })
@JsonTypeInfo(use = Id.DEDUCTION, defaultImpl = JsonObject.class)
public interface ViewResponse {
}
