package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.lenra.app.gen.components.Icon;
import io.lenra.app.gen.components.LenraComponent;
import java.util.HashMap;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputDecoration {
  // Fields
  private Boolean alignLabelWithHint;
  private InputBorder border;
  private BoxConstraints constraints;
  private Padding contentPadding;
  private HashMap<String, Object> counter;
  private TextStyle counterStyle;
  private String counterText;
  private InputBorder disabledBorder;
  private Boolean enabled;
  private InputBorder enabledBorder;
  private InputBorder errorBorder;
  private Integer errorMaxLines;
  private TextStyle errorStyle;
  private String errorText;
  private Integer fillColor;
  private Boolean filled;
  private FloatingLabelBehavior floatingLabelBehavior;
  private TextStyle floatingLabelStyle;
  private Integer focusColor;
  private InputBorder focusedBorder;
  private InputBorder focusedErrorBorder;
  private Integer helperMaxLines;
  private TextStyle helperStyle;
  private String helperText;
  private Integer hintMaxLines;
  private TextStyle hintStyle;
  private String hintText;
  private TextDirection hintTextDirection;
  private Integer hoverColor;
  private Icon icon;
  private Integer iconColor;
  private Boolean isCollapsed;
  private Boolean isDense;
  private LenraComponent label;
  private TextStyle labelStyle;
  private String labelText;
  private LenraComponent prefix;
  private Icon prefixIcon;
  private Integer prefixIconColor;
  private BoxConstraints prefixIconConstraints;
  private TextStyle prefixStyle;
  private String prefixText;
  private String semanticCounterText;
  private HashMap<String, Object> suffix;
  private Icon suffixIcon;
  private Integer suffixIconColor;
  private BoxConstraints suffixIconConstraints;
  private TextStyle suffixStyle;
  private String suffixText;
}
