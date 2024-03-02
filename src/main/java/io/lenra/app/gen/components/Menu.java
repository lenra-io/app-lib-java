package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu implements LenraComponent {
  // Fields
  private ArrayList<LenraComponent> children;
  @JsonProperty("_type")
  private final String type = "menu";
}
