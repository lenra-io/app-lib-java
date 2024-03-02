package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.List;
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
  private List<String> fontFamilyFallback;
  private Double fontSize;
  private FontStyle  fontStyle;
  private FontWeight  fontWeight;
  private Double height;
  private Double letterSpacing;
  private Overflow  overflow;
  private List<BoxShadow> shadows;
  private TextBaseline textBaseline;
  private Double wordSpacing;

  // Sub elements

  public enum FontStyle  {
    // Values
    @JsonProperty("italic")
    ITALIC,
    @JsonProperty("normal")
    NORMAL;
  }

  public enum FontWeight  {
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

  public enum Overflow  {
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
