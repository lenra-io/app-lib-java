package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Alignment {
  // Values
  @JsonProperty("bottomCenter")
  BOTTOM_CENTER,
  @JsonProperty("bottomLeft")
  BOTTOM_LEFT,
  @JsonProperty("bottomRight")
  BOTTOM_RIGHT,
  @JsonProperty("center")
  CENTER,
  @JsonProperty("centerLeft")
  CENTER_LEFT,
  @JsonProperty("centerRight")
  CENTER_RIGHT,
  @JsonProperty("topCenter")
  TOP_CENTER,
  @JsonProperty("topLeft")
  TOP_LEFT,
  @JsonProperty("topRight")
  TOP_RIGHT;
}
