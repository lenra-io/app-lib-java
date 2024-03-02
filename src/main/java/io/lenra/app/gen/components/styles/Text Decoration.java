package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Text Decoration {
  // Values
  @JsonProperty("lineThrough")
  LINE_THROUGH,
  @JsonProperty("overline")
  OVERLINE,
  @JsonProperty("underline")
  UNDERLINE,
  @JsonProperty("none")
  NONE;
}
