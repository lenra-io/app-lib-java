package io.lenra.app.components.styles;


public class SliderStyle extends SliderStyleBase {

  // Constructors
  public SliderStyle() {
    super();
  }

  public SliderStyle(Integer activeColor, Integer inactiveColor, Integer thumbColor) {
    super();
    this.setActiveColor(activeColor);
    this.setInactiveColor(inactiveColor);
    this.setThumbColor(thumbColor);
  }


  // Methods
  public SliderStyle activeColor(Integer activeColor) {
    this.setActiveColor(activeColor);
    return this;
  }

  public SliderStyle inactiveColor(Integer inactiveColor) {
    this.setInactiveColor(inactiveColor);
    return this;
  }

  public SliderStyle thumbColor(Integer thumbColor) {
    this.setThumbColor(thumbColor);
    return this;
  }

}
