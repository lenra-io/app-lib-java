package io.lenra.app.components;

import io.lenra.app.components.icon.definitions.IconStyle;
import io.lenra.app.components.styles.IconName;

public class Icon extends IconBase implements LenraComponent {

  // Constructors
  public Icon() {
    super();
  }

  public Icon(IconName value) {
    this.setValue(value);
  }

  public Icon(Double size, Integer color, String semanticLabel, IconName value, IconStyle style) {
    super();
    this.setSize(size);
    this.setColor(color);
    this.setSemanticLabel(semanticLabel);
    this.setValue(value);
    this.setStyle(style);
  }


  // Methods
  public Icon size(Double size) {
    this.setSize(size);
    return this;
  }

  public Icon color(Integer color) {
    this.setColor(color);
    return this;
  }

  public Icon semanticLabel(String semanticLabel) {
    this.setSemanticLabel(semanticLabel);
    return this;
  }

  public Icon value(IconName value) {
    this.setValue(value);
    return this;
  }

  public Icon style(IconStyle style) {
    this.setStyle(style);
    return this;
  }

}
