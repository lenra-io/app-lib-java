package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextInputType {
  // Fields
  private Boolean copy;
  private Boolean cut;
  private Boolean paste;
  private Boolean selectAll;
}
