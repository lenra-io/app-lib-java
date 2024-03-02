package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuItem implements LenraComponent {
  // Fields
  private Boolean disabled;
  private Icon icon;
  private Boolean isSelected;
  private Listener onPressed;
  private String text;
  @JsonProperty("_type")
  private final String type = "menuItem";
}
