package io.lenra.app.components.styles;


public class RadioStyle extends RadioStyleBase {

  // Constructors
  public RadioStyle() {
    super();
  }

  public RadioStyle(Integer activeColor, Integer focusColor, Integer hovercolor, Integer unselectedColor, Double splashRadius, VisualDensity visualDensity) {
    super();
    this.setActiveColor(activeColor);
    this.setFocusColor(focusColor);
    this.setHovercolor(hovercolor);
    this.setUnselectedColor(unselectedColor);
    this.setSplashRadius(splashRadius);
    this.setVisualDensity(visualDensity);
  }


  // Methods
  public RadioStyle activeColor(Integer activeColor) {
    this.setActiveColor(activeColor);
    return this;
  }

  public RadioStyle focusColor(Integer focusColor) {
    this.setFocusColor(focusColor);
    return this;
  }

  public RadioStyle hovercolor(Integer hovercolor) {
    this.setHovercolor(hovercolor);
    return this;
  }

  public RadioStyle unselectedColor(Integer unselectedColor) {
    this.setUnselectedColor(unselectedColor);
    return this;
  }

  public RadioStyle splashRadius(Double splashRadius) {
    this.setSplashRadius(splashRadius);
    return this;
  }

  public RadioStyle visualDensity(VisualDensity visualDensity) {
    this.setVisualDensity(visualDensity);
    return this;
  }

}
