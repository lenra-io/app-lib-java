package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BoxHeightStyle {
  // Values
  @JsonProperty("includeLineSpacingBottom")
  INCLUDE_LINE_SPACING_BOTTOM,
  @JsonProperty("includeLineSpacingMiddle")
  INCLUDE_LINE_SPACING_MIDDLE,
  @JsonProperty("includeLineSpacingTop")
  INCLUDE_LINE_SPACING_TOP,
  @JsonProperty("max")
  MAX,
  @JsonProperty("strut")
  STRUT,
  @JsonProperty("tight")
  TIGHT;
}
