package io.lenra.app.components.styles.borderradius.definitions;


public class Radius extends RadiusBase {

  // Constructors
  public Radius() {
    super();
  }

  public Radius(Double x, Double y) {
    super();
    this.setX(x);
    this.setY(y);
  }


  // Methods
  public Radius x(Double x) {
    this.setX(x);
    return this;
  }

  public Radius y(Double y) {
    this.setY(y);
    return this;
  }

}
