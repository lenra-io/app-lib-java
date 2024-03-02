package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputBorder {
  // Fields
  private BorderRadius borderRadius;
  private BorderSide borderSide;
  private InputBorder.Type  type;

  // Sub elements

  public static enum Type  {
    // Values
    @JsonProperty("underline")
    UNDERLINE,
    @JsonProperty("outline")
    OUTLINE;
  }

}
