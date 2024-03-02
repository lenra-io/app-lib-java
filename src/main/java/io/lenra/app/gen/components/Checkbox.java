package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.CheckboxStyle;
import io.lenra.app.gen.components.styles.MaterialTapTargetSize;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Checkbox implements LenraComponent {
  // Fields
  private Boolean autofocus;
  private MaterialTapTargetSize materialTapTargetSize;
  private String name;
  private Listener onPressed;
  private CheckboxStyle style;
  private Boolean tristate;
  @JsonProperty("_type")
  private final String type = "checkbox";
  private Boolean value;
}
