package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Style {
  // Values
  @JsonProperty("primary")
  PRIMARY,
  @JsonProperty("secondary")
  SECONDARY,
  @JsonProperty("tertiary")
  TERTIARY;
}
