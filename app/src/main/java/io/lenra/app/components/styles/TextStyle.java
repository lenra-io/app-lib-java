package io.lenra.app.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.annotation.processing.Generated;

public class TextStyle extends TextStyleBase {

  // Constructors
  public TextStyle() {
    super();
  }

  public TextStyle(Integer color, TextDecoration decoration, Integer decorationColor, TextDecorationStyle decorationStyle, Double decorationThickness, String fontFamily, List<String> fontFamilyFallback, Double fontSize, TextStyle.FontStyle  fontStyle, TextStyle.FontWeight  fontWeight, Double height, Double letterSpacing, TextStyle.Overflow  overflow, List<BoxShadow> shadows, TextBaseline textBaseline, Double wordSpacing) {
    super();
    this.setColor(color);
    this.setDecoration(decoration);
    this.setDecorationColor(decorationColor);
    this.setDecorationStyle(decorationStyle);
    this.setDecorationThickness(decorationThickness);
    this.setFontFamily(fontFamily);
    this.setFontFamilyFallback(fontFamilyFallback);
    this.setFontSize(fontSize);
    this.setFontStyle(fontStyle);
    this.setFontWeight(fontWeight);
    this.setHeight(height);
    this.setLetterSpacing(letterSpacing);
    this.setOverflow(overflow);
    this.setShadows(shadows);
    this.setTextBaseline(textBaseline);
    this.setWordSpacing(wordSpacing);
  }


  // Methods
  public TextStyle color(Integer color) {
    this.setColor(color);
    return this;
  }

  public TextStyle decoration(TextDecoration decoration) {
    this.setDecoration(decoration);
    return this;
  }

  public TextStyle decorationColor(Integer decorationColor) {
    this.setDecorationColor(decorationColor);
    return this;
  }

  public TextStyle decorationStyle(TextDecorationStyle decorationStyle) {
    this.setDecorationStyle(decorationStyle);
    return this;
  }

  public TextStyle decorationThickness(Double decorationThickness) {
    this.setDecorationThickness(decorationThickness);
    return this;
  }

  public TextStyle fontFamily(String fontFamily) {
    this.setFontFamily(fontFamily);
    return this;
  }

  public TextStyle fontFamilyFallback(List<String> fontFamilyFallback) {
    this.setFontFamilyFallback(fontFamilyFallback);
    return this;
  }

  public TextStyle fontSize(Double fontSize) {
    this.setFontSize(fontSize);
    return this;
  }

  public TextStyle fontStyle(TextStyle.FontStyle  fontStyle) {
    this.setFontStyle(fontStyle);
    return this;
  }

  public TextStyle fontWeight(TextStyle.FontWeight  fontWeight) {
    this.setFontWeight(fontWeight);
    return this;
  }

  public TextStyle height(Double height) {
    this.setHeight(height);
    return this;
  }

  public TextStyle letterSpacing(Double letterSpacing) {
    this.setLetterSpacing(letterSpacing);
    return this;
  }

  public TextStyle overflow(TextStyle.Overflow  overflow) {
    this.setOverflow(overflow);
    return this;
  }

  public TextStyle shadows(List<BoxShadow> shadows) {
    this.setShadows(shadows);
    return this;
  }

  public TextStyle textBaseline(TextBaseline textBaseline) {
    this.setTextBaseline(textBaseline);
    return this;
  }

  public TextStyle wordSpacing(Double wordSpacing) {
    this.setWordSpacing(wordSpacing);
    return this;
  }


  // Sub elements

  @Generated("JSON Schema")
  public static enum FontStyle  {
    // Values
    @JsonProperty("italic")
    ITALIC,
    @JsonProperty("normal")
    NORMAL;
  }

  @Generated("JSON Schema")
  public static enum FontWeight  {
    // Values
    @JsonProperty("bold")
    BOLD,
    @JsonProperty("normal")
    NORMAL,
    @JsonProperty("w100")
    W100,
    @JsonProperty("w200")
    W200,
    @JsonProperty("w300")
    W300,
    @JsonProperty("w400")
    W400,
    @JsonProperty("w500")
    W500,
    @JsonProperty("w600")
    W600,
    @JsonProperty("w700")
    W700,
    @JsonProperty("w800")
    W800,
    @JsonProperty("w900")
    W900;
  }

  @Generated("JSON Schema")
  public static enum Overflow  {
    // Values
    @JsonProperty("clip")
    CLIP,
    @JsonProperty("ellipsis")
    ELLIPSIS,
    @JsonProperty("fade")
    FADE,
    @JsonProperty("visible")
    VISIBLE;
  }

}
