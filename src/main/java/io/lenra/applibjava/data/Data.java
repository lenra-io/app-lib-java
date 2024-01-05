package io.lenra.applibjava.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

public abstract class Data {
    @JsonProperty("_id")
    @Getter
    private String id;

    public Data() {
    }

    public Data(String id) {
        this.id = id;
    }
}
