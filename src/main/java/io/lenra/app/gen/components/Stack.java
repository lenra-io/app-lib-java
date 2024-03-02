package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.Alignment;
import io.lenra.app.gen.components.styles.StackFit;
import java.util.ArrayList;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Stack implements LenraComponent {
  // Fields
  private Alignment alignment;
  private ArrayList<LenraComponent> children;
  private StackFit fit;
  @JsonProperty("_type")
  private final String type = "stack";
}
