package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.icon.definitions.IconStyle;
import io.lenra.app.gen.components.styles.IconName;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Icon implements LenraComponent {
  // Fields
  private Integer color;
  private String semanticLabel;
  private Double size;
  private IconStyle style;
  @JsonProperty("_type")
  private final String type = "icon";
  private IconName value;
}
