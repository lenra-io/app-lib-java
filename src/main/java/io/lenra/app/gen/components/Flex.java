package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.Direction;
import io.lenra.app.gen.components.styles.Padding;
import io.lenra.app.gen.components.styles.TextBaseline;
import io.lenra.app.gen.components.styles.TextDirection;
import io.lenra.app.gen.components.styles.VerticalDirection;
import java.util.ArrayList;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flex implements LenraComponent {
  // Fields
  private ArrayList<LenraComponent> children;
  private Flex.CrossAxisAlignment  crossAxisAlignment;
  private Direction direction;
  private Boolean fillParent;
  private TextDirection horizontalDirection;
  private Flex.MainAxisAlignment  mainAxisAlignment;
  private Padding padding;
  private Boolean scroll;
  private Double spacing;
  private TextBaseline textBaseline;
  @JsonProperty("_type")
  private final String type = "flex";
  private VerticalDirection verticalDirection;

  // Sub elements

  public static enum CrossAxisAlignment  {
    // Values
    @JsonProperty("start")
    START,
    @JsonProperty("end")
    END,
    @JsonProperty("center")
    CENTER,
    @JsonProperty("stretch")
    STRETCH,
    @JsonProperty("baseline")
    BASELINE;
  }

  public static enum MainAxisAlignment  {
    // Values
    @JsonProperty("start")
    START,
    @JsonProperty("end")
    END,
    @JsonProperty("center")
    CENTER,
    @JsonProperty("spaceBetween")
    SPACE_BETWEEN,
    @JsonProperty("spaceAround")
    SPACE_AROUND,
    @JsonProperty("spaceEvenly")
    SPACE_EVENLY;
  }

}
