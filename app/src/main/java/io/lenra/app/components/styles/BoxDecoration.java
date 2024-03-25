package io.lenra.app.components.styles;


public class BoxDecoration extends BoxDecorationBase {

  // Constructors
  public BoxDecoration() {
    super();
  }

  public BoxDecoration(BorderRadius borderRadius, BoxShadow boxShadow, Integer color, BoxShape shape) {
    super();
    this.setBorderRadius(borderRadius);
    this.setBoxShadow(boxShadow);
    this.setColor(color);
    this.setShape(shape);
  }


  // Methods
  public BoxDecoration borderRadius(BorderRadius borderRadius) {
    this.setBorderRadius(borderRadius);
    return this;
  }

  public BoxDecoration boxShadow(BoxShadow boxShadow) {
    this.setBoxShadow(boxShadow);
    return this;
  }

  public BoxDecoration color(Integer color) {
    this.setColor(color);
    return this;
  }

  public BoxDecoration shape(BoxShape shape) {
    this.setShape(shape);
    return this;
  }

}
