package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextFieldStyle {
  // Fields
  private Integer cursorColor;
  private Double cursorHeight;
  private Radius cursorRadius;
  private Double cursorWidth;
  private InputDecoration decoration;
  private Brightness keyboardAppearance;
  private String obscuringCharacter;
  private Padding scrollPadding;
  private BoxHeightStyle selectionHeightStyle;
  private BoxWidthStyle selectionWidthStyle;
  private StrutStyle strutStyle;
  private TextAlign textAlign;
  private TextAlignVertical textAlignVertical;
  private TextStyle textStyle;
}
