package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MaxLengthEnforcement {
  // Values
  @JsonProperty("none")
  NONE,
  @JsonProperty("enforced")
  ENFORCED,
  @JsonProperty("truncateAfterCompositionEnds")
  TRUNCATE_AFTER_COMPOSITION_ENDS;
}
