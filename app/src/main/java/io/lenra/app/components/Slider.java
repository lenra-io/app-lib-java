package io.lenra.app.components;

import io.lenra.app.components.styles.SliderStyle;

public class Slider extends SliderBase implements LenraComponent {

  // Constructors
  public Slider() {
    super();
  }

  public Slider(SliderStyle style, Boolean autofocus, Double divisions, String label, Double min, Double max, Listener onChanged, Listener onChangeEnd, Listener onChangeStart, Double value, String name) {
    super();
    this.setStyle(style);
    this.setAutofocus(autofocus);
    this.setDivisions(divisions);
    this.setLabel(label);
    this.setMin(min);
    this.setMax(max);
    this.setOnChanged(onChanged);
    this.setOnChangeEnd(onChangeEnd);
    this.setOnChangeStart(onChangeStart);
    this.setValue(value);
    this.setName(name);
  }


  // Methods
  public Slider style(SliderStyle style) {
    this.setStyle(style);
    return this;
  }

  public Slider autofocus(Boolean autofocus) {
    this.setAutofocus(autofocus);
    return this;
  }

  public Slider divisions(Double divisions) {
    this.setDivisions(divisions);
    return this;
  }

  public Slider label(String label) {
    this.setLabel(label);
    return this;
  }

  public Slider min(Double min) {
    this.setMin(min);
    return this;
  }

  public Slider max(Double max) {
    this.setMax(max);
    return this;
  }

  public Slider onChanged(Listener onChanged) {
    this.setOnChanged(onChanged);
    return this;
  }

  public Slider onChangeEnd(Listener onChangeEnd) {
    this.setOnChangeEnd(onChangeEnd);
    return this;
  }

  public Slider onChangeStart(Listener onChangeStart) {
    this.setOnChangeStart(onChangeStart);
    return this;
  }

  public Slider value(Double value) {
    this.setValue(value);
    return this;
  }

  public Slider name(String name) {
    this.setName(name);
    return this;
  }

}
