package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextStyle {
  // Fields
  private Integer color;
  private Text Decoration decoration;
  private Integer decorationColor;
  private Text Decoration Style decorationStyle;
  private Double decorationThickness;
  private String fontFamily;
  private ArrayList<String> fontFamilyFallback;
  private Double fontSize;
  private TextStyle.FontStyle  fontStyle;
  private TextStyle.FontWeight  fontWeight;
  private Double height;
  private Double letterSpacing;
  private TextStyle.Overflow  overflow;
  private ArrayList<BoxShadow> shadows;
  private TextBaseline textBaseline;
  private Double wordSpacing;

  // Sub elements

  public static enum FontStyle  {
    // Values
    @JsonProperty("italic")
    ITALIC,
    @JsonProperty("normal")
    NORMAL;
  }

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
