package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OverlayEntry implements LenraComponent {
  // Fields
  private LenraComponent child;
  private Boolean maintainState;
  private Boolean opaque;
  private Boolean showOverlay;
  @JsonProperty("_type")
  private final String type = "overlayEntry";
}
