package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.view.definitions.Find;
import io.lenra.app.gen.defs.Props;
import java.util.HashMap;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class View implements LenraComponent {
  // Fields
  private HashMap<String, Object> context;
  private Find find;
  private String name;
  private Props props;
  @JsonProperty("_type")
  private final String type = "view";
}