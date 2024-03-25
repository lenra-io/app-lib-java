package io.lenra.app;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import io.lenra.app.requests.ListenerRequest;
import io.lenra.app.requests.ManifestRequest;
import io.lenra.app.requests.ResourceRequest;
import io.lenra.app.requests.ViewRequest;

@JsonTypeInfo(use = Id.DEDUCTION, defaultImpl = ManifestRequest.class)
@JsonSubTypes({ @Type(ViewRequest.class), @Type(ListenerRequest.class), @Type(ResourceRequest.class), @Type(ManifestRequest.class) })
public interface AppRequest {
}
