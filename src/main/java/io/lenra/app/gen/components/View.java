package io.lenra.app.gen.components;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.view.definitions.Find;
import io.lenra.app.gen.defs.Props;
import java.util.HashMap;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class View {
@JsonProperty("_type") final String type = "view";
  String name;
  Props props;
  Find find;
  HashMap<String, Object> context;
}
