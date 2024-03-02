package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BoxFit {
  // Values
  @JsonProperty("contain")
  CONTAIN,
  @JsonProperty("cover")
  COVER,
  @JsonProperty("fill")
  FILL,
  @JsonProperty("fitHeight")
  FIT_HEIGHT,
  @JsonProperty("fitWidth")
  FIT_WIDTH,
  @JsonProperty("none")
  NONE,
  @JsonProperty("scaleDown")
  SCALE_DOWN;
}
