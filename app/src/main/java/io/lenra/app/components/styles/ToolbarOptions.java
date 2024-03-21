package io.lenra.app.components.styles;


public class ToolbarOptions extends ToolbarOptionsBase {

  // Constructors
  public ToolbarOptions() {
    super();
  }

  public ToolbarOptions(Boolean decimal, Boolean signed) {
    super();
    this.setDecimal(decimal);
    this.setSigned(signed);
  }


  // Methods
  public ToolbarOptions decimal(Boolean decimal) {
    this.setDecimal(decimal);
    return this;
  }

  public ToolbarOptions signed(Boolean signed) {
    this.setSigned(signed);
    return this;
  }

}
