package io.lenra.app.components;

import io.lenra.app.components.styles.IconName;
import io.lenra.app.view.Filler;
import java.util.List;

public class Components {

  // Static methods
  public static View view(String name) {
    return new View(name);
  }

  public static View view(String name, Filler<View> filler) {
    var ret = new View(name);
    filler.fill(ret);
    return ret;
  }

  public static Actionable actionable(LenraComponent child) {
    return new Actionable(child);
  }

  public static Actionable actionable(LenraComponent child, Filler<Actionable> filler) {
    var ret = new Actionable(child);
    filler.fill(ret);
    return ret;
  }

  public static Listener listener(String name) {
    return new Listener(name);
  }

  public static Listener listener(String name, Filler<Listener> filler) {
    var ret = new Listener(name);
    filler.fill(ret);
    return ret;
  }

  public static Button button(String text) {
    return new Button(text);
  }

  public static Button button(String text, Filler<Button> filler) {
    var ret = new Button(text);
    filler.fill(ret);
    return ret;
  }

  public static Icon icon(IconName value) {
    return new Icon(value);
  }

  public static Icon icon(IconName value, Filler<Icon> filler) {
    var ret = new Icon(value);
    filler.fill(ret);
    return ret;
  }

  public static Carousel carousel(List<LenraComponent> children) {
    return new Carousel(children);
  }

  public static Carousel carousel(List<LenraComponent> children, Filler<Carousel> filler) {
    var ret = new Carousel(children);
    filler.fill(ret);
    return ret;
  }

  public static Checkbox checkbox(Boolean value) {
    return new Checkbox(value);
  }

  public static Checkbox checkbox(Boolean value, Filler<Checkbox> filler) {
    var ret = new Checkbox(value);
    filler.fill(ret);
    return ret;
  }

  public static Container container() {
    return new Container();
  }

  public static Container container(Filler<Container> filler) {
    var ret = new Container();
    filler.fill(ret);
    return ret;
  }

  public static DropdownButton dropdownButton(String text, LenraComponent child) {
    return new DropdownButton(text, child);
  }

  public static DropdownButton dropdownButton(String text, LenraComponent child, Filler<DropdownButton> filler) {
    var ret = new DropdownButton(text, child);
    filler.fill(ret);
    return ret;
  }

  public static Flex flex(List<LenraComponent> children) {
    return new Flex(children);
  }

  public static Flex flex(List<LenraComponent> children, Filler<Flex> filler) {
    var ret = new Flex(children);
    filler.fill(ret);
    return ret;
  }

  public static Flexible flexible(LenraComponent child) {
    return new Flexible(child);
  }

  public static Flexible flexible(LenraComponent child, Filler<Flexible> filler) {
    var ret = new Flexible(child);
    filler.fill(ret);
    return ret;
  }

  public static Form form(LenraComponent child) {
    return new Form(child);
  }

  public static Form form(LenraComponent child, Filler<Form> filler) {
    var ret = new Form(child);
    filler.fill(ret);
    return ret;
  }

  public static Image image(String src) {
    return new Image(src);
  }

  public static Image image(String src, Filler<Image> filler) {
    var ret = new Image(src);
    filler.fill(ret);
    return ret;
  }

  public static Menu menu(List<LenraComponent> children) {
    return new Menu(children);
  }

  public static Menu menu(List<LenraComponent> children, Filler<Menu> filler) {
    var ret = new Menu(children);
    filler.fill(ret);
    return ret;
  }

  public static MenuItem menuItem(String text) {
    return new MenuItem(text);
  }

  public static MenuItem menuItem(String text, Filler<MenuItem> filler) {
    var ret = new MenuItem(text);
    filler.fill(ret);
    return ret;
  }

  public static OverlayEntry overlayEntry(LenraComponent child) {
    return new OverlayEntry(child);
  }

  public static OverlayEntry overlayEntry(LenraComponent child, Filler<OverlayEntry> filler) {
    var ret = new OverlayEntry(child);
    filler.fill(ret);
    return ret;
  }

  public static Radio radio(String value, String groupValue) {
    return new Radio(value, groupValue);
  }

  public static Radio radio(String value, String groupValue, Filler<Radio> filler) {
    var ret = new Radio(value, groupValue);
    filler.fill(ret);
    return ret;
  }

  public static Slider slider() {
    return new Slider();
  }

  public static Slider slider(Filler<Slider> filler) {
    var ret = new Slider();
    filler.fill(ret);
    return ret;
  }

  public static Stack stack(List<LenraComponent> children) {
    return new Stack(children);
  }

  public static Stack stack(List<LenraComponent> children, Filler<Stack> filler) {
    var ret = new Stack(children);
    filler.fill(ret);
    return ret;
  }

  public static StatusSticker statusSticker(StatusSticker.Status  status) {
    return new StatusSticker(status);
  }

  public static StatusSticker statusSticker(StatusSticker.Status  status, Filler<StatusSticker> filler) {
    var ret = new StatusSticker(status);
    filler.fill(ret);
    return ret;
  }

  public static Text text(String value) {
    return new Text(value);
  }

  public static Text text(String value, Filler<Text> filler) {
    var ret = new Text(value);
    filler.fill(ret);
    return ret;
  }

  public static TextField textField(String value) {
    return new TextField(value);
  }

  public static TextField textField(String value, Filler<TextField> filler) {
    var ret = new TextField(value);
    filler.fill(ret);
    return ret;
  }

  public static Toggle toggle(Boolean value) {
    return new Toggle(value);
  }

  public static Toggle toggle(Boolean value, Filler<Toggle> filler) {
    var ret = new Toggle(value);
    filler.fill(ret);
    return ret;
  }

  public static Wrap wrap(List<LenraComponent> children) {
    return new Wrap(children);
  }

  public static Wrap wrap(List<LenraComponent> children, Filler<Wrap> filler) {
    var ret = new Wrap(children);
    filler.fill(ret);
    return ret;
  }

}
