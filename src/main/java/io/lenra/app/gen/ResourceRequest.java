package io.lenra.app.gen;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceRequest implements AppRequest {
  // Fields
  private String resource;
}
