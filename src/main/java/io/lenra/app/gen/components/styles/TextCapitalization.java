package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TextCapitalization {
  // Values
  @JsonProperty("none")
  NONE,
  @JsonProperty("words")
  WORDS,
  @JsonProperty("sentences")
  SENTENCES,
  @JsonProperty("characters")
  CHARACTERS;
}
