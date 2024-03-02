package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.ToggleStyle;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Toggle implements LenraComponent {
  // Fields
  private Boolean autofocus;
  private Boolean disabled;
  private DragStartBehavior  dragStartBehavior;
  private String name;
  private Listener onPressed;
  private Double splashRadius;
  private ToggleStyle style;
  @JsonProperty("_type")
  private final String type = "toggle";
  private Boolean value;

  // Sub elements

  public enum DragStartBehavior  {
    // Values
    @JsonProperty("start")
    START,
    @JsonProperty("down")
    DOWN;
  }

}
