package io.lenra.app.components.styles;


public class OutlinedBorder extends OutlinedBorderBase {

  // Constructors
  public OutlinedBorder() {
    super();
  }

  public OutlinedBorder(BorderSide side) {
    super();
    this.setSide(side);
  }


  // Methods
  public OutlinedBorder side(BorderSide side) {
    this.setSide(side);
    return this;
  }

}
