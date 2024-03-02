package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoxConstraints {
  // Fields
  private Double maxHeight;
  private Double maxWidth;
  private Double minHeight;
  private Double minWidth;
}
