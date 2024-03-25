package io.lenra.app.components;

import io.lenra.app.components.styles.CarouselOptions;
import java.util.List;

public class Carousel extends CarouselBase implements LenraComponent {

  // Constructors
  public Carousel() {
    super();
  }

  public Carousel(List<LenraComponent> children) {
    this.setChildren(children);
  }

  public Carousel(List<LenraComponent> children, CarouselOptions options) {
    super();
    this.setChildren(children);
    this.setOptions(options);
  }


  // Methods
  public Carousel children(List<LenraComponent> children) {
    this.setChildren(children);
    return this;
  }

  public Carousel options(CarouselOptions options) {
    this.setOptions(options);
    return this;
  }

}
