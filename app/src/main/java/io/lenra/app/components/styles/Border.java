package io.lenra.app.components.styles;


public class Border extends BorderBase {

  // Constructors
  public Border() {
    super();
  }

  public Border(BorderSide top, BorderSide left, BorderSide bottom, BorderSide right) {
    super();
    this.setTop(top);
    this.setLeft(left);
    this.setBottom(bottom);
    this.setRight(right);
  }


  // Methods
  public Border top(BorderSide top) {
    this.setTop(top);
    return this;
  }

  public Border left(BorderSide left) {
    this.setLeft(left);
    return this;
  }

  public Border bottom(BorderSide bottom) {
    this.setBottom(bottom);
    return this;
  }

  public Border right(BorderSide right) {
    this.setRight(right);
    return this;
  }

}
