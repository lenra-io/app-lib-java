package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum WrapAlignment {
  // Values
  @JsonProperty("start")
  START,
  @JsonProperty("end")
  END,
  @JsonProperty("center")
  CENTER,
  @JsonProperty("spaceBetween")
  SPACE_BETWEEN,
  @JsonProperty("spaceAround")
  SPACE_AROUND,
  @JsonProperty("spaceEvenly")
  SPACE_EVENLY;
}
