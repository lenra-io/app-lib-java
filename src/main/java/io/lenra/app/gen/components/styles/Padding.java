package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Padding {
  // Fields
  private Double bottom;
  private Double left;
  private Double right;
  private Double top;
}
