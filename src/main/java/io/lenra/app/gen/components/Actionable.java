package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Actionable implements LenraComponent {
  // Fields
  private LenraComponent child;
  private Listener onDoublePressed;
  private Listener onHovered;
  private Listener onLongPressed;
  private Listener onPressed;
  private Listener onPressedCancel;
  private Boolean submit;
  @JsonProperty("_type")
  private final String type = "actionable";
}
