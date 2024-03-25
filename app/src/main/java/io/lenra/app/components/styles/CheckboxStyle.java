package io.lenra.app.components.styles;


public class CheckboxStyle extends CheckboxStyleBase {

  // Constructors
  public CheckboxStyle() {
    super();
  }

  public CheckboxStyle(Integer activeColor, Integer checkColor, Integer focusColor, Integer hoverColor, Double splashRadius, VisualDensity visualDensity, OutlinedBorder shape, BorderSide side) {
    super();
    this.setActiveColor(activeColor);
    this.setCheckColor(checkColor);
    this.setFocusColor(focusColor);
    this.setHoverColor(hoverColor);
    this.setSplashRadius(splashRadius);
    this.setVisualDensity(visualDensity);
    this.setShape(shape);
    this.setSide(side);
  }


  // Methods
  public CheckboxStyle activeColor(Integer activeColor) {
    this.setActiveColor(activeColor);
    return this;
  }

  public CheckboxStyle checkColor(Integer checkColor) {
    this.setCheckColor(checkColor);
    return this;
  }

  public CheckboxStyle focusColor(Integer focusColor) {
    this.setFocusColor(focusColor);
    return this;
  }

  public CheckboxStyle hoverColor(Integer hoverColor) {
    this.setHoverColor(hoverColor);
    return this;
  }

  public CheckboxStyle splashRadius(Double splashRadius) {
    this.setSplashRadius(splashRadius);
    return this;
  }

  public CheckboxStyle visualDensity(VisualDensity visualDensity) {
    this.setVisualDensity(visualDensity);
    return this;
  }

  public CheckboxStyle shape(OutlinedBorder shape) {
    this.setShape(shape);
    return this;
  }

  public CheckboxStyle side(BorderSide side) {
    this.setSide(side);
    return this;
  }

}
