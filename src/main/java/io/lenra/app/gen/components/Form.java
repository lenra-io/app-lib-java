package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Form implements LenraComponent {
  // Fields
  private LenraComponent child;
  private Listener onSubmit;
  @JsonProperty("_type")
  private final String type = "form";
}
