package io.lenra.app.components;

import io.lenra.app.components.styles.autofillhints.Items;
import io.lenra.app.components.styles.DragStartBehavior;
import io.lenra.app.components.styles.MaxLengthEnforcement;
import io.lenra.app.components.styles.TextCapitalization;
import io.lenra.app.components.styles.TextDirection;
import io.lenra.app.components.styles.TextFieldStyle;
import io.lenra.app.components.styles.TextInputAction;
import io.lenra.app.components.styles.TextInputType;
import io.lenra.app.components.styles.ToolbarOptions;
import java.util.List;

public class TextField extends TextFieldBase implements LenraComponent {

  // Constructors
  public TextField() {
    super();
  }

  public TextField(String value) {
    this.setValue(value);
  }

  public TextField(String value, Boolean autocorrect, List<Items> autofillHints, Boolean autofocus, Listener buildCounter, TextFieldStyle style, DragStartBehavior dragStartBehavior, Boolean enabled, Boolean enableInteractiveSelection, Boolean expands, TextInputType keyboardType, Integer maxLength, MaxLengthEnforcement maxLengthEnforcement, Integer maxLines, Integer minLines, Boolean obscureText, Listener onAppPrivateCommand, Listener onChanged, Listener onEditingComplete, Listener onSubmitted, Listener onTap, Boolean readOnly, Boolean showCursor, TextCapitalization textCapitalization, TextDirection textDirection, TextInputAction textInputAction, ToolbarOptions toolbarOptions, String name) {
    super();
    this.setValue(value);
    this.setAutocorrect(autocorrect);
    this.setAutofillHints(autofillHints);
    this.setAutofocus(autofocus);
    this.setBuildCounter(buildCounter);
    this.setStyle(style);
    this.setDragStartBehavior(dragStartBehavior);
    this.setEnabled(enabled);
    this.setEnableInteractiveSelection(enableInteractiveSelection);
    this.setExpands(expands);
    this.setKeyboardType(keyboardType);
    this.setMaxLength(maxLength);
    this.setMaxLengthEnforcement(maxLengthEnforcement);
    this.setMaxLines(maxLines);
    this.setMinLines(minLines);
    this.setObscureText(obscureText);
    this.setOnAppPrivateCommand(onAppPrivateCommand);
    this.setOnChanged(onChanged);
    this.setOnEditingComplete(onEditingComplete);
    this.setOnSubmitted(onSubmitted);
    this.setOnTap(onTap);
    this.setReadOnly(readOnly);
    this.setShowCursor(showCursor);
    this.setTextCapitalization(textCapitalization);
    this.setTextDirection(textDirection);
    this.setTextInputAction(textInputAction);
    this.setToolbarOptions(toolbarOptions);
    this.setName(name);
  }


  // Methods
  public TextField value(String value) {
    this.setValue(value);
    return this;
  }

  public TextField autocorrect(Boolean autocorrect) {
    this.setAutocorrect(autocorrect);
    return this;
  }

  public TextField autofillHints(List<Items> autofillHints) {
    this.setAutofillHints(autofillHints);
    return this;
  }

  public TextField autofocus(Boolean autofocus) {
    this.setAutofocus(autofocus);
    return this;
  }

  public TextField buildCounter(Listener buildCounter) {
    this.setBuildCounter(buildCounter);
    return this;
  }

  public TextField style(TextFieldStyle style) {
    this.setStyle(style);
    return this;
  }

  public TextField dragStartBehavior(DragStartBehavior dragStartBehavior) {
    this.setDragStartBehavior(dragStartBehavior);
    return this;
  }

  public TextField enabled(Boolean enabled) {
    this.setEnabled(enabled);
    return this;
  }

  public TextField enableInteractiveSelection(Boolean enableInteractiveSelection) {
    this.setEnableInteractiveSelection(enableInteractiveSelection);
    return this;
  }

  public TextField expands(Boolean expands) {
    this.setExpands(expands);
    return this;
  }

  public TextField keyboardType(TextInputType keyboardType) {
    this.setKeyboardType(keyboardType);
    return this;
  }

  public TextField maxLength(Integer maxLength) {
    this.setMaxLength(maxLength);
    return this;
  }

  public TextField maxLengthEnforcement(MaxLengthEnforcement maxLengthEnforcement) {
    this.setMaxLengthEnforcement(maxLengthEnforcement);
    return this;
  }

  public TextField maxLines(Integer maxLines) {
    this.setMaxLines(maxLines);
    return this;
  }

  public TextField minLines(Integer minLines) {
    this.setMinLines(minLines);
    return this;
  }

  public TextField obscureText(Boolean obscureText) {
    this.setObscureText(obscureText);
    return this;
  }

  public TextField onAppPrivateCommand(Listener onAppPrivateCommand) {
    this.setOnAppPrivateCommand(onAppPrivateCommand);
    return this;
  }

  public TextField onChanged(Listener onChanged) {
    this.setOnChanged(onChanged);
    return this;
  }

  public TextField onEditingComplete(Listener onEditingComplete) {
    this.setOnEditingComplete(onEditingComplete);
    return this;
  }

  public TextField onSubmitted(Listener onSubmitted) {
    this.setOnSubmitted(onSubmitted);
    return this;
  }

  public TextField onTap(Listener onTap) {
    this.setOnTap(onTap);
    return this;
  }

  public TextField readOnly(Boolean readOnly) {
    this.setReadOnly(readOnly);
    return this;
  }

  public TextField showCursor(Boolean showCursor) {
    this.setShowCursor(showCursor);
    return this;
  }

  public TextField textCapitalization(TextCapitalization textCapitalization) {
    this.setTextCapitalization(textCapitalization);
    return this;
  }

  public TextField textDirection(TextDirection textDirection) {
    this.setTextDirection(textDirection);
    return this;
  }

  public TextField textInputAction(TextInputAction textInputAction) {
    this.setTextInputAction(textInputAction);
    return this;
  }

  public TextField toolbarOptions(ToolbarOptions toolbarOptions) {
    this.setToolbarOptions(toolbarOptions);
    return this;
  }

  public TextField name(String name) {
    this.setName(name);
    return this;
  }

}
