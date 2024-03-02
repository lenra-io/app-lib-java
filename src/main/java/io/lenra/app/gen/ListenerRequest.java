package io.lenra.app.gen;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.lenra.app.gen.defs.Props;
import io.lenra.app.gen.listener.definitions.ApiInformations;
import java.util.HashMap;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListenerRequest implements AppRequest {
  // Fields
  private ApiInformations api;
  private HashMap<String, Object> event;
  private String listener;
  private Props props;
}
