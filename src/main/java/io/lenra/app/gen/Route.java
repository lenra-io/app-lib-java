package io.lenra.app.gen;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.lenra.app.gen.components.View;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route {
String path;
  View view;
  List<String> roles;
}
