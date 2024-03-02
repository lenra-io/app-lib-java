package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.Size;
import io.lenra.app.gen.components.styles.Style;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DropdownButton implements LenraComponent {
  // Fields
  private LenraComponent child;
  private Boolean disabled;
  private Icon icon;
  private Style mainStyle;
  private Size size;
  private String text;
  @JsonProperty("_type")
  private final String type = "dropdownButton";
}
