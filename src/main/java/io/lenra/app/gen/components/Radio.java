package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.MaterialTapTargetSize;
import io.lenra.app.gen.components.styles.RadioStyle;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Radio implements LenraComponent {
  // Fields
  private Boolean autofocus;
  private String groupValue;
  private MaterialTapTargetSize materialTapTargetSize;
  private String name;
  private Listener onPressed;
  private RadioStyle style;
  private Boolean toggleable;
  @JsonProperty("_type")
  private final String type = "radio";
  private String value;
}
