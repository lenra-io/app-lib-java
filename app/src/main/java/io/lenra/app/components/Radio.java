package io.lenra.app.components;

import io.lenra.app.components.styles.MaterialTapTargetSize;
import io.lenra.app.components.styles.RadioStyle;

public class Radio extends RadioBase implements LenraComponent {

  // Constructors
  public Radio() {
    super();
  }

  public Radio(String value, String groupValue) {
    this.setValue(value);
    this.setGroupValue(groupValue);
  }

  public Radio(Boolean autofocus, String value, String groupValue, MaterialTapTargetSize materialTapTargetSize, Listener onPressed, Boolean toggleable, RadioStyle style, String name) {
    super();
    this.setAutofocus(autofocus);
    this.setValue(value);
    this.setGroupValue(groupValue);
    this.setMaterialTapTargetSize(materialTapTargetSize);
    this.setOnPressed(onPressed);
    this.setToggleable(toggleable);
    this.setStyle(style);
    this.setName(name);
  }


  // Methods
  public Radio autofocus(Boolean autofocus) {
    this.setAutofocus(autofocus);
    return this;
  }

  public Radio value(String value) {
    this.setValue(value);
    return this;
  }

  public Radio groupValue(String groupValue) {
    this.setGroupValue(groupValue);
    return this;
  }

  public Radio materialTapTargetSize(MaterialTapTargetSize materialTapTargetSize) {
    this.setMaterialTapTargetSize(materialTapTargetSize);
    return this;
  }

  public Radio onPressed(Listener onPressed) {
    this.setOnPressed(onPressed);
    return this;
  }

  public Radio toggleable(Boolean toggleable) {
    this.setToggleable(toggleable);
    return this;
  }

  public Radio style(RadioStyle style) {
    this.setStyle(style);
    return this;
  }

  public Radio name(String name) {
    this.setName(name);
    return this;
  }

}
