package io.lenra.app.gen.components.view.definitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashMap;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Find {
  // Fields
  private String coll;
  private HashMap<String, Object> projection;
  private HashMap<String, Object> query;
}
