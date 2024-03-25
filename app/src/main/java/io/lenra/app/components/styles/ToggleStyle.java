package io.lenra.app.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.components.Image;
import javax.annotation.processing.Generated;

public class ToggleStyle extends ToggleStyleBase {

  // Constructors
  public ToggleStyle() {
    super();
  }

  public ToggleStyle(Integer activeColor, Integer activeTrackColor, Integer inactiveTrackColor, Integer inactiveThumbColor, Integer hoverColor, Integer focusColor, Image activeThumbImage, Image inactiveThumbImage, ToggleStyle.MaterialTapTargetSize  materialTapTargetSize) {
    super();
    this.setActiveColor(activeColor);
    this.setActiveTrackColor(activeTrackColor);
    this.setInactiveTrackColor(inactiveTrackColor);
    this.setInactiveThumbColor(inactiveThumbColor);
    this.setHoverColor(hoverColor);
    this.setFocusColor(focusColor);
    this.setActiveThumbImage(activeThumbImage);
    this.setInactiveThumbImage(inactiveThumbImage);
    this.setMaterialTapTargetSize(materialTapTargetSize);
  }


  // Methods
  public ToggleStyle activeColor(Integer activeColor) {
    this.setActiveColor(activeColor);
    return this;
  }

  public ToggleStyle activeTrackColor(Integer activeTrackColor) {
    this.setActiveTrackColor(activeTrackColor);
    return this;
  }

  public ToggleStyle inactiveTrackColor(Integer inactiveTrackColor) {
    this.setInactiveTrackColor(inactiveTrackColor);
    return this;
  }

  public ToggleStyle inactiveThumbColor(Integer inactiveThumbColor) {
    this.setInactiveThumbColor(inactiveThumbColor);
    return this;
  }

  public ToggleStyle hoverColor(Integer hoverColor) {
    this.setHoverColor(hoverColor);
    return this;
  }

  public ToggleStyle focusColor(Integer focusColor) {
    this.setFocusColor(focusColor);
    return this;
  }

  public ToggleStyle activeThumbImage(Image activeThumbImage) {
    this.setActiveThumbImage(activeThumbImage);
    return this;
  }

  public ToggleStyle inactiveThumbImage(Image inactiveThumbImage) {
    this.setInactiveThumbImage(inactiveThumbImage);
    return this;
  }

  public ToggleStyle materialTapTargetSize(ToggleStyle.MaterialTapTargetSize  materialTapTargetSize) {
    this.setMaterialTapTargetSize(materialTapTargetSize);
    return this;
  }


  // Sub elements

  @Generated("JSON Schema")
  public static enum MaterialTapTargetSize  {
    // Values
    @JsonProperty("padded")
    PADDED,
    @JsonProperty("shrinkWrap")
    SHRINK_WRAP;
  }

}
