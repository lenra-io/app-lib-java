package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.Size;
import io.lenra.app.gen.components.styles.Style;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Button implements LenraComponent {
  // Fields
  private Boolean disabled;
  private Icon leftIcon;
  private Style mainStyle;
  private Listener onPressed;
  private Icon rightIcon;
  private Size size;
  private Boolean submit;
  private String text;
  @JsonProperty("_type")
  private final String type = "button";
}
