package io.lenra.app.components;


public class MenuItem extends MenuItemBase implements LenraComponent {

  // Constructors
  public MenuItem() {
    super();
  }

  public MenuItem(String text) {
    this.setText(text);
  }

  public MenuItem(String text, Boolean isSelected, Boolean disabled, Icon icon, Listener onPressed) {
    super();
    this.setText(text);
    this.setIsSelected(isSelected);
    this.setDisabled(disabled);
    this.setIcon(icon);
    this.setOnPressed(onPressed);
  }


  // Methods
  public MenuItem text(String text) {
    this.setText(text);
    return this;
  }

  public MenuItem isSelected(Boolean isSelected) {
    this.setIsSelected(isSelected);
    return this;
  }

  public MenuItem disabled(Boolean disabled) {
    this.setDisabled(disabled);
    return this;
  }

  public MenuItem icon(Icon icon) {
    this.setIcon(icon);
    return this;
  }

  public MenuItem onPressed(Listener onPressed) {
    this.setOnPressed(onPressed);
    return this;
  }

}
