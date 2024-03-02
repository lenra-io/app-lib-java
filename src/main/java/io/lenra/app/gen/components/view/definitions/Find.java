package io.lenra.app.gen.components.view.definitions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.lenra.app.gen.data.Projection;
import io.lenra.app.gen.data.Query;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Find {
  // Fields
  private String coll;
  private Projection projection;
  private Query query;
}
