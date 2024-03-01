package io.lenra.app.gen;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.lenra.app.gen.components.View;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route {
  // Fields
  private String path;
  private List<String> roles;
  private View view;
}
