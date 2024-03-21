package io.lenra.app.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.components.styles.Locale;
import io.lenra.app.components.styles.TextStyle;
import java.util.List;
import javax.annotation.processing.Generated;

public class Text extends TextBase implements LenraComponent {

  // Constructors
  public Text() {
    super();
  }

  public Text(String value) {
    this.setValue(value);
  }

  public Text(String value, TextStyle style, Locale locale, String semanticsLabel, Boolean spellOut, Text.TextAlign  textAlign, List<Text> children) {
    super();
    this.setValue(value);
    this.setStyle(style);
    this.setLocale(locale);
    this.setSemanticsLabel(semanticsLabel);
    this.setSpellOut(spellOut);
    this.setTextAlign(textAlign);
    this.setChildren(children);
  }


  // Methods
  public Text value(String value) {
    this.setValue(value);
    return this;
  }

  public Text style(TextStyle style) {
    this.setStyle(style);
    return this;
  }

  public Text locale(Locale locale) {
    this.setLocale(locale);
    return this;
  }

  public Text semanticsLabel(String semanticsLabel) {
    this.setSemanticsLabel(semanticsLabel);
    return this;
  }

  public Text spellOut(Boolean spellOut) {
    this.setSpellOut(spellOut);
    return this;
  }

  public Text textAlign(Text.TextAlign  textAlign) {
    this.setTextAlign(textAlign);
    return this;
  }

  public Text children(List<Text> children) {
    this.setChildren(children);
    return this;
  }


  // Sub elements

  @Generated("JSON Schema")
  public static enum TextAlign  {
    // Values
    @JsonProperty("left")
    LEFT,
    @JsonProperty("center")
    CENTER,
    @JsonProperty("right")
    RIGHT,
    @JsonProperty("justify")
    JUSTIFY,
    @JsonProperty("start")
    START,
    @JsonProperty("end")
    END;
  }

}
