package io.lenra.app.components;

import io.lenra.app.components.styles.FlexFit;

public class Flexible extends FlexibleBase implements LenraComponent {

  // Constructors
  public Flexible() {
    super();
  }

  public Flexible(LenraComponent child) {
    this.setChild(child);
  }

  public Flexible(Integer flex, FlexFit fit, LenraComponent child) {
    super();
    this.setFlex(flex);
    this.setFit(fit);
    this.setChild(child);
  }


  // Methods
  public Flexible flex(Integer flex) {
    this.setFlex(flex);
    return this;
  }

  public Flexible fit(FlexFit fit) {
    this.setFit(fit);
    return this;
  }

  public Flexible child(LenraComponent child) {
    this.setChild(child);
    return this;
  }

}
