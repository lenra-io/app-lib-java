package io.lenra.app.components;


public class Actionable extends ActionableBase implements LenraComponent {

  // Constructors
  public Actionable() {
    super();
  }

  public Actionable(LenraComponent child) {
    this.setChild(child);
  }

  public Actionable(LenraComponent child, Listener onPressed, Listener onDoublePressed, Listener onLongPressed, Listener onPressedCancel, Listener onHovered, Boolean submit) {
    super();
    this.setChild(child);
    this.setOnPressed(onPressed);
    this.setOnDoublePressed(onDoublePressed);
    this.setOnLongPressed(onLongPressed);
    this.setOnPressedCancel(onPressedCancel);
    this.setOnHovered(onHovered);
    this.setSubmit(submit);
  }


  // Methods
  public Actionable child(LenraComponent child) {
    this.setChild(child);
    return this;
  }

  public Actionable onPressed(Listener onPressed) {
    this.setOnPressed(onPressed);
    return this;
  }

  public Actionable onDoublePressed(Listener onDoublePressed) {
    this.setOnDoublePressed(onDoublePressed);
    return this;
  }

  public Actionable onLongPressed(Listener onLongPressed) {
    this.setOnLongPressed(onLongPressed);
    return this;
  }

  public Actionable onPressedCancel(Listener onPressedCancel) {
    this.setOnPressedCancel(onPressedCancel);
    return this;
  }

  public Actionable onHovered(Listener onHovered) {
    this.setOnHovered(onHovered);
    return this;
  }

  public Actionable submit(Boolean submit) {
    this.setSubmit(submit);
    return this;
  }

}
