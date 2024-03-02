package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FilterQuality {
  // Values
  @JsonProperty("high")
  HIGH,
  @JsonProperty("medium")
  MEDIUM,
  @JsonProperty("low")
  LOW,
  @JsonProperty("none")
  NONE;
}
