package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.defs.Props;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Listener {
  // Fields
  private String name;
  private Props props;
  @JsonProperty("_type")
  private final String type = "listener";
}
