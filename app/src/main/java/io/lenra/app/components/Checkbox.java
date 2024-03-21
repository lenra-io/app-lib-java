package io.lenra.app.components;

import io.lenra.app.components.styles.CheckboxStyle;
import io.lenra.app.components.styles.MaterialTapTargetSize;

public class Checkbox extends CheckboxBase implements LenraComponent {

  // Constructors
  public Checkbox() {
    super();
  }

  public Checkbox(Boolean value) {
    this.setValue(value);
  }

  public Checkbox(Boolean value, Boolean tristate, Listener onPressed, CheckboxStyle style, MaterialTapTargetSize materialTapTargetSize, Boolean autofocus, String name) {
    super();
    this.setValue(value);
    this.setTristate(tristate);
    this.setOnPressed(onPressed);
    this.setStyle(style);
    this.setMaterialTapTargetSize(materialTapTargetSize);
    this.setAutofocus(autofocus);
    this.setName(name);
  }


  // Methods
  public Checkbox value(Boolean value) {
    this.setValue(value);
    return this;
  }

  public Checkbox tristate(Boolean tristate) {
    this.setTristate(tristate);
    return this;
  }

  public Checkbox onPressed(Listener onPressed) {
    this.setOnPressed(onPressed);
    return this;
  }

  public Checkbox style(CheckboxStyle style) {
    this.setStyle(style);
    return this;
  }

  public Checkbox materialTapTargetSize(MaterialTapTargetSize materialTapTargetSize) {
    this.setMaterialTapTargetSize(materialTapTargetSize);
    return this;
  }

  public Checkbox autofocus(Boolean autofocus) {
    this.setAutofocus(autofocus);
    return this;
  }

  public Checkbox name(String name) {
    this.setName(name);
    return this;
  }

}
