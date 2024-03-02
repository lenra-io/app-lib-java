package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rect {
  // Fields
  private Double height;
  private Double left;
  private Double top;
  private Double width;
}
