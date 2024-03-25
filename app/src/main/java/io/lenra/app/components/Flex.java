package io.lenra.app.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.components.styles.Direction;
import io.lenra.app.components.styles.Padding;
import io.lenra.app.components.styles.TextBaseline;
import io.lenra.app.components.styles.TextDirection;
import io.lenra.app.components.styles.VerticalDirection;
import java.util.List;
import javax.annotation.processing.Generated;

public class Flex extends FlexBase implements LenraComponent {

  // Constructors
  public Flex() {
    super();
  }

  public Flex(List<LenraComponent> children) {
    this.setChildren(children);
  }

  public Flex(List<LenraComponent> children, Direction direction, Flex.MainAxisAlignment  mainAxisAlignment, Flex.CrossAxisAlignment  crossAxisAlignment, Double spacing, Boolean fillParent, Boolean scroll, Padding padding, TextDirection horizontalDirection, VerticalDirection verticalDirection, TextBaseline textBaseline) {
    super();
    this.setChildren(children);
    this.setDirection(direction);
    this.setMainAxisAlignment(mainAxisAlignment);
    this.setCrossAxisAlignment(crossAxisAlignment);
    this.setSpacing(spacing);
    this.setFillParent(fillParent);
    this.setScroll(scroll);
    this.setPadding(padding);
    this.setHorizontalDirection(horizontalDirection);
    this.setVerticalDirection(verticalDirection);
    this.setTextBaseline(textBaseline);
  }


  // Methods
  public Flex children(List<LenraComponent> children) {
    this.setChildren(children);
    return this;
  }

  public Flex direction(Direction direction) {
    this.setDirection(direction);
    return this;
  }

  public Flex mainAxisAlignment(Flex.MainAxisAlignment  mainAxisAlignment) {
    this.setMainAxisAlignment(mainAxisAlignment);
    return this;
  }

  public Flex crossAxisAlignment(Flex.CrossAxisAlignment  crossAxisAlignment) {
    this.setCrossAxisAlignment(crossAxisAlignment);
    return this;
  }

  public Flex spacing(Double spacing) {
    this.setSpacing(spacing);
    return this;
  }

  public Flex fillParent(Boolean fillParent) {
    this.setFillParent(fillParent);
    return this;
  }

  public Flex scroll(Boolean scroll) {
    this.setScroll(scroll);
    return this;
  }

  public Flex padding(Padding padding) {
    this.setPadding(padding);
    return this;
  }

  public Flex horizontalDirection(TextDirection horizontalDirection) {
    this.setHorizontalDirection(horizontalDirection);
    return this;
  }

  public Flex verticalDirection(VerticalDirection verticalDirection) {
    this.setVerticalDirection(verticalDirection);
    return this;
  }

  public Flex textBaseline(TextBaseline textBaseline) {
    this.setTextBaseline(textBaseline);
    return this;
  }


  // Sub elements

  @Generated("JSON Schema")
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

  @Generated("JSON Schema")
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
