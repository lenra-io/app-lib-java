package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.FlexFit;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flexible implements LenraComponent {
  // Fields
  private LenraComponent child;
  private FlexFit fit;
  private Integer flex;
  @JsonProperty("_type")
  private final String type = "flexible";
}
