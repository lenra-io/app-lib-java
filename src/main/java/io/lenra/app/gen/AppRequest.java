package io.lenra.app.gen;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonSubTypes({ @Type(ViewRequest.class), @Type(ListenerRequest.class), @Type(ResourceRequest.class) })
@JsonTypeInfo(use = Id.DEDUCTION, defaultImpl = ResourceRequest.class)
public interface AppRequest {
}
