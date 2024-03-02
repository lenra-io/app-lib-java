package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TextAlign {
  // Values
  @JsonProperty("left")
  LEFT,
  @JsonProperty("right")
  RIGHT,
  @JsonProperty("center")
  CENTER,
  @JsonProperty("justify")
  JUSTIFY,
  @JsonProperty("start")
  START,
  @JsonProperty("end")
  END;
}
