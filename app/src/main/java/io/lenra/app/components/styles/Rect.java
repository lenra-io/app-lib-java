package io.lenra.app.components.styles;


public class Rect extends RectBase {

  // Constructors
  public Rect() {
    super();
  }

  public Rect(Double left, Double top, Double width, Double height) {
    super();
    this.setLeft(left);
    this.setTop(top);
    this.setWidth(width);
    this.setHeight(height);
  }


  // Methods
  public Rect left(Double left) {
    this.setLeft(left);
    return this;
  }

  public Rect top(Double top) {
    this.setTop(top);
    return this;
  }

  public Rect width(Double width) {
    this.setWidth(width);
    return this;
  }

  public Rect height(Double height) {
    this.setHeight(height);
    return this;
  }

}
