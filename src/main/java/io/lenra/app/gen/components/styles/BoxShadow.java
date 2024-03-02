package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoxShadow {
  // Fields
  private Double blurRadius;
  private Integer color;
  private Offset offset;
  private Double spreadRadius;
}
