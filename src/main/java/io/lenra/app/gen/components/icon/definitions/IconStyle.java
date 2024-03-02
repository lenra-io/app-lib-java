package io.lenra.app.gen.components.icon.definitions;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum IconStyle {
  // Values
  @JsonProperty("filled")
  FILLED,
  @JsonProperty("sharp")
  SHARP,
  @JsonProperty("rounded")
  ROUNDED,
  @JsonProperty("outlined")
  OUTLINED;
}
