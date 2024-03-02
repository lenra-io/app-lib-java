package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputBorder {
  // Fields
  private BorderRadius borderRadius;
  private BorderSide borderSide;
  private Type  type;

  // Sub elements

  public enum Type  {
    // Values
    @JsonProperty("underline")
    UNDERLINE,
    @JsonProperty("outline")
    OUTLINE;
  }

}
