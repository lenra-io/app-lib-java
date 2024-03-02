package io.lenra.app.gen.components.styles.borderradius.definitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Radius {
  // Fields
  private Double x;
  private Double y;
}
