package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.lenra.app.gen.components.view.definitions.Find;
import java.util.HashMap;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class View {
  // Fields
  private HashMap<String, Object> context;
  private Find find;
  private String name;
  private HashMap<String, Object> props;
  private final String type = "view";
}
