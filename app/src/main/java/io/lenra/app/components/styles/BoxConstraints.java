package io.lenra.app.components.styles;


public class BoxConstraints extends BoxConstraintsBase {

  // Constructors
  public BoxConstraints() {
    super();
  }

  public BoxConstraints(Double minWidth, Double maxWidth, Double minHeight, Double maxHeight) {
    super();
    this.setMinWidth(minWidth);
    this.setMaxWidth(maxWidth);
    this.setMinHeight(minHeight);
    this.setMaxHeight(maxHeight);
  }


  // Methods
  public BoxConstraints minWidth(Double minWidth) {
    this.setMinWidth(minWidth);
    return this;
  }

  public BoxConstraints maxWidth(Double maxWidth) {
    this.setMaxWidth(maxWidth);
    return this;
  }

  public BoxConstraints minHeight(Double minHeight) {
    this.setMinHeight(minHeight);
    return this;
  }

  public BoxConstraints maxHeight(Double maxHeight) {
    this.setMaxHeight(maxHeight);
    return this;
  }

}
