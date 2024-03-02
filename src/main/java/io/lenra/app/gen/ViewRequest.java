package io.lenra.app.gen;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.lenra.app.gen.data.result.find.Items;
import io.lenra.app.gen.defs.Props;
import java.util.HashMap;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ViewRequest implements AppRequest {
  // Fields
  private HashMap<String, Object> context;
  private List<Items> data;
  private Props props;
  private String view;
}
