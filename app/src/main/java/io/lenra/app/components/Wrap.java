package io.lenra.app.components;

import io.lenra.app.components.styles.Direction;
import io.lenra.app.components.styles.TextDirection;
import io.lenra.app.components.styles.VerticalDirection;
import io.lenra.app.components.styles.WrapAlignment;
import io.lenra.app.components.styles.WrapCrossAlignment;
import java.util.List;

public class Wrap extends WrapBase implements LenraComponent {

  // Constructors
  public Wrap() {
    super();
  }

  public Wrap(List<LenraComponent> children) {
    this.setChildren(children);
  }

  public Wrap(List<LenraComponent> children, Direction direction, WrapCrossAlignment crossAxisAlignment, Double spacing, Double runSpacing, WrapAlignment alignment, WrapAlignment runAlignment, TextDirection horizontalDirection, VerticalDirection verticalDirection) {
    super();
    this.setChildren(children);
    this.setDirection(direction);
    this.setCrossAxisAlignment(crossAxisAlignment);
    this.setSpacing(spacing);
    this.setRunSpacing(runSpacing);
    this.setAlignment(alignment);
    this.setRunAlignment(runAlignment);
    this.setHorizontalDirection(horizontalDirection);
    this.setVerticalDirection(verticalDirection);
  }


  // Methods
  public Wrap children(List<LenraComponent> children) {
    this.setChildren(children);
    return this;
  }

  public Wrap direction(Direction direction) {
    this.setDirection(direction);
    return this;
  }

  public Wrap crossAxisAlignment(WrapCrossAlignment crossAxisAlignment) {
    this.setCrossAxisAlignment(crossAxisAlignment);
    return this;
  }

  public Wrap spacing(Double spacing) {
    this.setSpacing(spacing);
    return this;
  }

  public Wrap runSpacing(Double runSpacing) {
    this.setRunSpacing(runSpacing);
    return this;
  }

  public Wrap alignment(WrapAlignment alignment) {
    this.setAlignment(alignment);
    return this;
  }

  public Wrap runAlignment(WrapAlignment runAlignment) {
    this.setRunAlignment(runAlignment);
    return this;
  }

  public Wrap horizontalDirection(TextDirection horizontalDirection) {
    this.setHorizontalDirection(horizontalDirection);
    return this;
  }

  public Wrap verticalDirection(VerticalDirection verticalDirection) {
    this.setVerticalDirection(verticalDirection);
    return this;
  }

}
