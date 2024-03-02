package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TextInputAction {
  // Values
  @JsonProperty("continueAction")
  CONTINUE_ACTION,
  @JsonProperty("done")
  DONE,
  @JsonProperty("emergencyCall")
  EMERGENCY_CALL,
  @JsonProperty("go")
  GO,
  @JsonProperty("join")
  JOIN,
  @JsonProperty("newline")
  NEWLINE,
  @JsonProperty("next")
  NEXT,
  @JsonProperty("none")
  NONE,
  @JsonProperty("previous")
  PREVIOUS,
  @JsonProperty("route")
  ROUTE,
  @JsonProperty("search")
  SEARCH,
  @JsonProperty("send")
  SEND,
  @JsonProperty("unspecified")
  UNSPECIFIED;
}
