package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.lenra.app.gen.components.styles.borderRadius.definitions.Radius;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BorderRadius {
  // Fields
  private Radius bottomLeft;
  private Radius bottomRight;
  private Radius topLeft;
  private Radius topRight;
}
