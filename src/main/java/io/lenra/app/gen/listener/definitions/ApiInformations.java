package io.lenra.app.gen.listener.definitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiInformations {
  // Fields
  private String token;
  private String url;
}
