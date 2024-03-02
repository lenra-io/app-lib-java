package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum VisualDensity {
  // Values
  @JsonProperty("comfortable")
  COMFORTABLE,
  @JsonProperty("compact")
  COMPACT,
  @JsonProperty("standard")
  STANDARD;
}
