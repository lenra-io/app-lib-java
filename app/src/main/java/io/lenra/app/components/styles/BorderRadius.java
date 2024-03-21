package io.lenra.app.components.styles;

import io.lenra.app.components.styles.borderradius.definitions.Radius;

public class BorderRadius extends BorderRadiusBase {

  // Constructors
  public BorderRadius() {
    super();
  }

  public BorderRadius(Radius topLeft, Radius topRight, Radius bottomLeft, Radius bottomRight) {
    super();
    this.setTopLeft(topLeft);
    this.setTopRight(topRight);
    this.setBottomLeft(bottomLeft);
    this.setBottomRight(bottomRight);
  }


  // Methods
  public BorderRadius topLeft(Radius topLeft) {
    this.setTopLeft(topLeft);
    return this;
  }

  public BorderRadius topRight(Radius topRight) {
    this.setTopRight(topRight);
    return this;
  }

  public BorderRadius bottomLeft(Radius bottomLeft) {
    this.setBottomLeft(bottomLeft);
    return this;
  }

  public BorderRadius bottomRight(Radius bottomRight) {
    this.setBottomRight(bottomRight);
    return this;
  }

}
