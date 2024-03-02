package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.Alignment;
import io.lenra.app.gen.components.styles.Border;
import io.lenra.app.gen.components.styles.BoxConstraints;
import io.lenra.app.gen.components.styles.BoxDecoration;
import io.lenra.app.gen.components.styles.Padding;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Container implements LenraComponent {
  // Fields
  private Alignment alignment;
  private Border border;
  private LenraComponent child;
  private BoxConstraints constraints;
  private BoxDecoration decoration;
  private Padding padding;
  @JsonProperty("_type")
  private final String type = "container";
}
