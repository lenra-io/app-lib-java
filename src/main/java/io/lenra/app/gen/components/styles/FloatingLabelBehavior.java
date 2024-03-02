package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FloatingLabelBehavior {
  // Values
  @JsonProperty("always")
  ALWAYS,
  @JsonProperty("auto")
  AUTO,
  @JsonProperty("never")
  NEVER;
}
