package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.Direction;
import io.lenra.app.gen.components.styles.TextDirection;
import io.lenra.app.gen.components.styles.VerticalDirection;
import io.lenra.app.gen.components.styles.WrapAlignment;
import io.lenra.app.gen.components.styles.WrapCrossAlignment;
import java.util.ArrayList;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Wrap implements LenraComponent {
  // Fields
  private WrapAlignment alignment;
  private ArrayList<LenraComponent> children;
  private WrapCrossAlignment crossAxisAlignment;
  private Direction direction;
  private TextDirection horizontalDirection;
  private WrapAlignment runAlignment;
  private Double runSpacing;
  private Double spacing;
  @JsonProperty("_type")
  private final String type = "wrap";
  private VerticalDirection verticalDirection;
}
