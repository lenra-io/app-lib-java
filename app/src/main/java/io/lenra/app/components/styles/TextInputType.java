package io.lenra.app.components.styles;


public class TextInputType extends TextInputTypeBase {

  // Constructors
  public TextInputType() {
    super();
  }

  public TextInputType(Boolean copy, Boolean cut, Boolean paste, Boolean selectAll) {
    super();
    this.setCopy(copy);
    this.setCut(cut);
    this.setPaste(paste);
    this.setSelectAll(selectAll);
  }


  // Methods
  public TextInputType copy(Boolean copy) {
    this.setCopy(copy);
    return this;
  }

  public TextInputType cut(Boolean cut) {
    this.setCut(cut);
    return this;
  }

  public TextInputType paste(Boolean paste) {
    this.setPaste(paste);
    return this;
  }

  public TextInputType selectAll(Boolean selectAll) {
    this.setSelectAll(selectAll);
    return this;
  }

}
