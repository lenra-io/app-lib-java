package io.lenra.app.components.styles;


public class Offset extends OffsetBase {

  // Constructors
  public Offset() {
    super();
  }

  public Offset(Double dx, Double dy) {
    super();
    this.setDx(dx);
    this.setDy(dy);
  }


  // Methods
  public Offset dx(Double dx) {
    this.setDx(dx);
    return this;
  }

  public Offset dy(Double dy) {
    this.setDy(dy);
    return this;
  }

}
