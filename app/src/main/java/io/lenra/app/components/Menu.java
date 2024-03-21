package io.lenra.app.components;

import java.util.List;

public class Menu extends MenuBase implements LenraComponent {

  // Constructors
  public Menu() {
    super();
  }

  public Menu(List<LenraComponent> children) {
    this.setChildren(children);
  }


  // Methods
  public Menu children(List<LenraComponent> children) {
    this.setChildren(children);
    return this;
  }

}
