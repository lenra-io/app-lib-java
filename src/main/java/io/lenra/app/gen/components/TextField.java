package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.autofillHints.Items;
import io.lenra.app.gen.components.styles.DragStartBehavior;
import io.lenra.app.gen.components.styles.MaxLengthEnforcement;
import io.lenra.app.gen.components.styles.TextCapitalization;
import io.lenra.app.gen.components.styles.TextDirection;
import io.lenra.app.gen.components.styles.TextFieldStyle;
import io.lenra.app.gen.components.styles.TextInputAction;
import io.lenra.app.gen.components.styles.TextInputType;
import io.lenra.app.gen.components.styles.ToolbarOptions;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextField implements LenraComponent {
  // Fields
  private Boolean autocorrect;
  private List<Items> autofillHints;
  private Boolean autofocus;
  private Listener buildCounter;
  private DragStartBehavior dragStartBehavior;
  private Boolean enabled;
  private Boolean enableInteractiveSelection;
  private Boolean expands;
  private TextInputType keyboardType;
  private Integer maxLength;
  private MaxLengthEnforcement maxLengthEnforcement;
  private Integer maxLines;
  private Integer minLines;
  private String name;
  private Boolean obscureText;
  private Listener onAppPrivateCommand;
  private Listener onChanged;
  private Listener onEditingComplete;
  private Listener onSubmitted;
  private Listener onTap;
  private Boolean readOnly;
  private Boolean showCursor;
  private TextFieldStyle style;
  private TextCapitalization textCapitalization;
  private TextDirection textDirection;
  private TextInputAction textInputAction;
  private ToolbarOptions toolbarOptions;
  @JsonProperty("_type")
  private final String type = "textfield";
  private String value;
}
