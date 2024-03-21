package io.lenra.app.components.styles;


public class BorderSide extends BorderSideBase {

  // Constructors
  public BorderSide() {
    super();
  }

  public BorderSide(Double width, Integer color) {
    super();
    this.setWidth(width);
    this.setColor(color);
  }


  // Methods
  public BorderSide width(Double width) {
    this.setWidth(width);
    return this;
  }

  public BorderSide color(Integer color) {
    this.setColor(color);
    return this;
  }

}
