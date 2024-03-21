package io.lenra.app.components.styles;


public class TextFieldStyle extends TextFieldStyleBase {

  // Constructors
  public TextFieldStyle() {
    super();
  }

  public TextFieldStyle(Integer cursorColor, Double cursorHeight, Radius cursorRadius, Double cursorWidth, InputDecoration decoration, Brightness keyboardAppearance, String obscuringCharacter, Padding scrollPadding, BoxHeightStyle selectionHeightStyle, BoxWidthStyle selectionWidthStyle, StrutStyle strutStyle, TextStyle textStyle, TextAlign textAlign, TextAlignVertical textAlignVertical) {
    super();
    this.setCursorColor(cursorColor);
    this.setCursorHeight(cursorHeight);
    this.setCursorRadius(cursorRadius);
    this.setCursorWidth(cursorWidth);
    this.setDecoration(decoration);
    this.setKeyboardAppearance(keyboardAppearance);
    this.setObscuringCharacter(obscuringCharacter);
    this.setScrollPadding(scrollPadding);
    this.setSelectionHeightStyle(selectionHeightStyle);
    this.setSelectionWidthStyle(selectionWidthStyle);
    this.setStrutStyle(strutStyle);
    this.setTextStyle(textStyle);
    this.setTextAlign(textAlign);
    this.setTextAlignVertical(textAlignVertical);
  }


  // Methods
  public TextFieldStyle cursorColor(Integer cursorColor) {
    this.setCursorColor(cursorColor);
    return this;
  }

  public TextFieldStyle cursorHeight(Double cursorHeight) {
    this.setCursorHeight(cursorHeight);
    return this;
  }

  public TextFieldStyle cursorRadius(Radius cursorRadius) {
    this.setCursorRadius(cursorRadius);
    return this;
  }

  public TextFieldStyle cursorWidth(Double cursorWidth) {
    this.setCursorWidth(cursorWidth);
    return this;
  }

  public TextFieldStyle decoration(InputDecoration decoration) {
    this.setDecoration(decoration);
    return this;
  }

  public TextFieldStyle keyboardAppearance(Brightness keyboardAppearance) {
    this.setKeyboardAppearance(keyboardAppearance);
    return this;
  }

  public TextFieldStyle obscuringCharacter(String obscuringCharacter) {
    this.setObscuringCharacter(obscuringCharacter);
    return this;
  }

  public TextFieldStyle scrollPadding(Padding scrollPadding) {
    this.setScrollPadding(scrollPadding);
    return this;
  }

  public TextFieldStyle selectionHeightStyle(BoxHeightStyle selectionHeightStyle) {
    this.setSelectionHeightStyle(selectionHeightStyle);
    return this;
  }

  public TextFieldStyle selectionWidthStyle(BoxWidthStyle selectionWidthStyle) {
    this.setSelectionWidthStyle(selectionWidthStyle);
    return this;
  }

  public TextFieldStyle strutStyle(StrutStyle strutStyle) {
    this.setStrutStyle(strutStyle);
    return this;
  }

  public TextFieldStyle textStyle(TextStyle textStyle) {
    this.setTextStyle(textStyle);
    return this;
  }

  public TextFieldStyle textAlign(TextAlign textAlign) {
    this.setTextAlign(textAlign);
    return this;
  }

  public TextFieldStyle textAlignVertical(TextAlignVertical textAlignVertical) {
    this.setTextAlignVertical(textAlignVertical);
    return this;
  }

}
