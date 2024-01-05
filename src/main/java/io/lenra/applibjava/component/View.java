package io.lenra.applibjava.component;

import com.fasterxml.jackson.annotation.JsonProperty;

public class View {
    @JsonProperty("_type")
    private final String type = "view";
    private String name;

    public View() {
    }

    public View(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
