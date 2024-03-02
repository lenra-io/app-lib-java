package io.lenra.app.gen;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Exposer {
  // Fields
  private ArrayList<Route> routes;
  private String version;
}
