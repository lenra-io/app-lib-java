package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.Image;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToggleStyle {
  // Fields
  private Integer activeColor;
  private Image activeThumbImage;
  private Integer activeTrackColor;
  private Integer focusColor;
  private Integer hoverColor;
  private Integer inactiveThumbColor;
  private Image inactiveThumbImage;
  private Integer inactiveTrackColor;
  private ToggleStyle.MaterialTapTargetSize  materialTapTargetSize;

  // Sub elements

  public static enum MaterialTapTargetSize  {
    // Values
    @JsonProperty("padded")
    PADDED,
    @JsonProperty("shrinkWrap")
    SHRINK_WRAP;
  }

}
