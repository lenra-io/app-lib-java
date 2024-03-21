package io.lenra.app.components.styles;


public class BoxShadow extends BoxShadowBase {

  // Constructors
  public BoxShadow() {
    super();
  }

  public BoxShadow(Integer color, Double blurRadius, Double spreadRadius, Offset offset) {
    super();
    this.setColor(color);
    this.setBlurRadius(blurRadius);
    this.setSpreadRadius(spreadRadius);
    this.setOffset(offset);
  }


  // Methods
  public BoxShadow color(Integer color) {
    this.setColor(color);
    return this;
  }

  public BoxShadow blurRadius(Double blurRadius) {
    this.setBlurRadius(blurRadius);
    return this;
  }

  public BoxShadow spreadRadius(Double spreadRadius) {
    this.setSpreadRadius(spreadRadius);
    return this;
  }

  public BoxShadow offset(Offset offset) {
    this.setOffset(offset);
    return this;
  }

}
