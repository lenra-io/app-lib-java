package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RadioStyle {
  // Fields
  private Integer activeColor;
  private Integer focusColor;
  private Integer hovercolor;
  private Double splashRadius;
  private Integer unselectedColor;
  private VisualDensity visualDensity;
}
