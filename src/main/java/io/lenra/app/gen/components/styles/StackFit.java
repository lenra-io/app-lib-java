package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum StackFit {
  // Values
  @JsonProperty("expand")
  EXPAND,
  @JsonProperty("loose")
  LOOSE,
  @JsonProperty("passthrough")
  PASSTHROUGH;
}
