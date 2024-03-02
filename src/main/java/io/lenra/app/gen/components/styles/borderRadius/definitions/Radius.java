package io.lenra.app.gen.components.styles.borderRadius.definitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Radius {
  // Fields
  private Double x;
  private Double y;
}
