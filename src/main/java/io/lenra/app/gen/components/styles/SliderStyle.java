package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SliderStyle {
  // Fields
  private Integer activeColor;
  private Integer inactiveColor;
  private Integer thumbColor;
}
