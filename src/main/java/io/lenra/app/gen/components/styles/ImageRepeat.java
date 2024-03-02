package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ImageRepeat {
  // Values
  @JsonProperty("noRepeat")
  NO_REPEAT,
  @JsonProperty("repeat")
  REPEAT,
  @JsonProperty("repeatX")
  REPEAT_X,
  @JsonProperty("repeatY")
  REPEAT_Y;
}
