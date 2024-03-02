package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckboxStyle {
  // Fields
  private Integer activeColor;
  private Integer checkColor;
  private Integer focusColor;
  private Integer hoverColor;
  private OutlinedBorder shape;
  private BorderSide side;
  private Double splashRadius;
  private VisualDensity visualDensity;
}
