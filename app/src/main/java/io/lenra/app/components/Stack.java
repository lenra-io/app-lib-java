package io.lenra.app.components;

import io.lenra.app.components.styles.Alignment;
import io.lenra.app.components.styles.StackFit;
import java.util.List;

public class Stack extends StackBase implements LenraComponent {

  // Constructors
  public Stack() {
    super();
  }

  public Stack(List<LenraComponent> children) {
    this.setChildren(children);
  }

  public Stack(List<LenraComponent> children, Alignment alignment, StackFit fit) {
    super();
    this.setChildren(children);
    this.setAlignment(alignment);
    this.setFit(fit);
  }


  // Methods
  public Stack children(List<LenraComponent> children) {
    this.setChildren(children);
    return this;
  }

  public Stack alignment(Alignment alignment) {
    this.setAlignment(alignment);
    return this;
  }

  public Stack fit(StackFit fit) {
    this.setFit(fit);
    return this;
  }

}
