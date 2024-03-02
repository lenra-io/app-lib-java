package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Border {
  // Fields
  private BorderSide bottom;
  private BorderSide left;
  private BorderSide right;
  private BorderSide top;
}
