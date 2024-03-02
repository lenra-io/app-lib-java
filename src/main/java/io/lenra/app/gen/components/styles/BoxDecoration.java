package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoxDecoration {
  // Fields
  private BorderRadius borderRadius;
  private BoxShadow boxShadow;
  private Integer color;
  private BoxShape shape;
}
