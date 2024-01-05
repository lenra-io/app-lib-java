package io.lenra.app.classes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class LenraBody {
    public String view;
    public String listener;
    public String resource;
    public JsonArray data;
    public JsonObject props;
    public JsonObject context;
    public JsonObject event;
    public JsonObject api;

    public LenraBody() {
    }

    @Override
    public String toString() {
        return "{" +
                " widget='" + view + "'" +
                ", action='" + listener + "'" +
                ", resource='" + resource + "'" +
                ", data='" + data + "'" +
                ", props='" + props + "'" +
                ", context='" + context + "'" +
                ", event='" + event + "'" +
                ", api='" + api + "'" +
                "}";
    }

}