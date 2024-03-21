package io.lenra.app.components;

import io.lenra.app.components.styles.Size;
import io.lenra.app.components.styles.Style;

public class Button extends ButtonBase implements LenraComponent {

  // Constructors
  public Button() {
    super();
  }

  public Button(String text) {
    this.setText(text);
  }

  public Button(String text, Boolean disabled, Size size, Style mainStyle, Listener onPressed, Icon leftIcon, Icon rightIcon, Boolean submit) {
    super();
    this.setText(text);
    this.setDisabled(disabled);
    this.setSize(size);
    this.setMainStyle(mainStyle);
    this.setOnPressed(onPressed);
    this.setLeftIcon(leftIcon);
    this.setRightIcon(rightIcon);
    this.setSubmit(submit);
  }


  // Methods
  public Button text(String text) {
    this.setText(text);
    return this;
  }

  public Button disabled(Boolean disabled) {
    this.setDisabled(disabled);
    return this;
  }

  public Button size(Size size) {
    this.setSize(size);
    return this;
  }

  public Button mainStyle(Style mainStyle) {
    this.setMainStyle(mainStyle);
    return this;
  }

  public Button onPressed(Listener onPressed) {
    this.setOnPressed(onPressed);
    return this;
  }

  public Button leftIcon(Icon leftIcon) {
    this.setLeftIcon(leftIcon);
    return this;
  }

  public Button rightIcon(Icon rightIcon) {
    this.setRightIcon(rightIcon);
    return this;
  }

  public Button submit(Boolean submit) {
    this.setSubmit(submit);
    return this;
  }

}
