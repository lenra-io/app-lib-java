package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Text Decoration Style {
  // Values
  @JsonProperty("dashed")
  DASHED,
  @JsonProperty("dotted")
  DOTTED,
  @JsonProperty("double")
  DOUBLE,
  @JsonProperty("solid")
  SOLID,
  @JsonProperty("wavy")
  WAVY;
}
