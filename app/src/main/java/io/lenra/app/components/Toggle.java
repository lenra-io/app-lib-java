package io.lenra.app.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.components.styles.ToggleStyle;
import javax.annotation.processing.Generated;

public class Toggle extends ToggleBase implements LenraComponent {

  // Constructors
  public Toggle() {
    super();
  }

  public Toggle(Boolean value) {
    this.setValue(value);
  }

  public Toggle(Boolean value, Double splashRadius, Boolean autofocus, Toggle.DragStartBehavior  dragStartBehavior, Listener onPressed, ToggleStyle style, String name, Boolean disabled) {
    super();
    this.setValue(value);
    this.setSplashRadius(splashRadius);
    this.setAutofocus(autofocus);
    this.setDragStartBehavior(dragStartBehavior);
    this.setOnPressed(onPressed);
    this.setStyle(style);
    this.setName(name);
    this.setDisabled(disabled);
  }


  // Methods
  public Toggle value(Boolean value) {
    this.setValue(value);
    return this;
  }

  public Toggle splashRadius(Double splashRadius) {
    this.setSplashRadius(splashRadius);
    return this;
  }

  public Toggle autofocus(Boolean autofocus) {
    this.setAutofocus(autofocus);
    return this;
  }

  public Toggle dragStartBehavior(Toggle.DragStartBehavior  dragStartBehavior) {
    this.setDragStartBehavior(dragStartBehavior);
    return this;
  }

  public Toggle onPressed(Listener onPressed) {
    this.setOnPressed(onPressed);
    return this;
  }

  public Toggle style(ToggleStyle style) {
    this.setStyle(style);
    return this;
  }

  public Toggle name(String name) {
    this.setName(name);
    return this;
  }

  public Toggle disabled(Boolean disabled) {
    this.setDisabled(disabled);
    return this;
  }


  // Sub elements

  @Generated("JSON Schema")
  public static enum DragStartBehavior  {
    // Values
    @JsonProperty("start")
    START,
    @JsonProperty("down")
    DOWN;
  }

}
