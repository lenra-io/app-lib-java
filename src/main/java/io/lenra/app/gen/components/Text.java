package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.Locale;
import io.lenra.app.gen.components.styles.TextStyle;
import java.util.ArrayList;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Text implements LenraComponent {
  // Fields
  private ArrayList<Text> children;
  private Locale locale;
  private String semanticsLabel;
  private Boolean spellOut;
  private TextStyle style;
  private Text.TextAlign  textAlign;
  @JsonProperty("_type")
  private final String type = "text";
  private String value;

  // Sub elements

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