package io.lenra.app.gen;


import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Exposer {
String version;
  List<Route> routes;
}
