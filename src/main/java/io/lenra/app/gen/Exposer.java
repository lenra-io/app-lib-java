package io.lenra.app.gen;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Exposer {
  // Fields
  private List<Route> routes;
  private String version;
}
