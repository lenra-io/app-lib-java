package io.lenra.app.gen;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Manifest {
Exposer lenra;
  Exposer json;
}
