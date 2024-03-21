package io.lenra.app.components;

import io.lenra.app.components.styles.Size;
import io.lenra.app.components.styles.Style;

public class DropdownButton extends DropdownButtonBase implements LenraComponent {

  // Constructors
  public DropdownButton() {
    super();
  }

  public DropdownButton(String text, LenraComponent child) {
    this.setText(text);
    this.setChild(child);
  }

  public DropdownButton(String text, Boolean disabled, Size size, Style mainStyle, LenraComponent child, Icon icon) {
    super();
    this.setText(text);
    this.setDisabled(disabled);
    this.setSize(size);
    this.setMainStyle(mainStyle);
    this.setChild(child);
    this.setIcon(icon);
  }


  // Methods
  public DropdownButton text(String text) {
    this.setText(text);
    return this;
  }

  public DropdownButton disabled(Boolean disabled) {
    this.setDisabled(disabled);
    return this;
  }

  public DropdownButton size(Size size) {
    this.setSize(size);
    return this;
  }

  public DropdownButton mainStyle(Style mainStyle) {
    this.setMainStyle(mainStyle);
    return this;
  }

  public DropdownButton child(LenraComponent child) {
    this.setChild(child);
    return this;
  }

  public DropdownButton icon(Icon icon) {
    this.setIcon(icon);
    return this;
  }

}
