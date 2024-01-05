package io.lenra.app.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import io.lenra.app.LenraApplication;

@JsonTypeInfo(use = Id.DEDUCTION, defaultImpl = ManifestRequest.class) // Intended usage
@JsonSubTypes({ @Type(ViewRequest.class), @Type(ListenerRequest.class), @Type(ManifestRequest.class) })
public abstract class AppRequest<T> {
    abstract public T handle(LenraApplication application);
}