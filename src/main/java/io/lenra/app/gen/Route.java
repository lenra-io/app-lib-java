package io.lenra.app.gen;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.lenra.app.gen.components.View;
import java.util.ArrayList;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route {
  // Fields
  private String path;
  private ArrayList<String> roles;
  private View view;
}
