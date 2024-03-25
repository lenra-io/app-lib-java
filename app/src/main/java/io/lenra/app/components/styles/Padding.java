package io.lenra.app.components.styles;


public class Padding extends PaddingBase {

  // Constructors
  public Padding() {
    super();
  }

  public Padding(Double top, Double left, Double bottom, Double right) {
    super();
    this.setTop(top);
    this.setLeft(left);
    this.setBottom(bottom);
    this.setRight(right);
  }


  // Methods
  public Padding top(Double top) {
    this.setTop(top);
    return this;
  }

  public Padding left(Double left) {
    this.setLeft(left);
    return this;
  }

  public Padding bottom(Double bottom) {
    this.setBottom(bottom);
    return this;
  }

  public Padding right(Double right) {
    this.setRight(right);
    return this;
  }

}
