package io.lenra.app.components;

import io.lenra.app.components.styles.Alignment;
import io.lenra.app.components.styles.Border;
import io.lenra.app.components.styles.BoxConstraints;
import io.lenra.app.components.styles.BoxDecoration;
import io.lenra.app.components.styles.Padding;

public class Container extends ContainerBase implements LenraComponent {

  // Constructors
  public Container() {
    super();
  }

  public Container(LenraComponent child, Alignment alignment, Border border, Padding padding, BoxConstraints constraints, BoxDecoration decoration) {
    super();
    this.setChild(child);
    this.setAlignment(alignment);
    this.setBorder(border);
    this.setPadding(padding);
    this.setConstraints(constraints);
    this.setDecoration(decoration);
  }


  // Methods
  public Container child(LenraComponent child) {
    this.setChild(child);
    return this;
  }

  public Container alignment(Alignment alignment) {
    this.setAlignment(alignment);
    return this;
  }

  public Container border(Border border) {
    this.setBorder(border);
    return this;
  }

  public Container padding(Padding padding) {
    this.setPadding(padding);
    return this;
  }

  public Container constraints(BoxConstraints constraints) {
    this.setConstraints(constraints);
    return this;
  }

  public Container decoration(BoxDecoration decoration) {
    this.setDecoration(decoration);
    return this;
  }

}
