package io.lenra.app.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.processing.Generated;

public class InputBorder extends InputBorderBase {

  // Constructors
  public InputBorder() {
    super();
  }

  public InputBorder(BorderSide borderSide) {
    this.setBorderSide(borderSide);
  }

  public InputBorder(InputBorder.Type  type, BorderRadius borderRadius, BorderSide borderSide) {
    super();
    this.setType(type);
    this.setBorderRadius(borderRadius);
    this.setBorderSide(borderSide);
  }


  // Methods
  public InputBorder type(InputBorder.Type  type) {
    this.setType(type);
    return this;
  }

  public InputBorder borderRadius(BorderRadius borderRadius) {
    this.setBorderRadius(borderRadius);
    return this;
  }

  public InputBorder borderSide(BorderSide borderSide) {
    this.setBorderSide(borderSide);
    return this;
  }


  // Sub elements

  @Generated("JSON Schema")
  public static enum Type  {
    // Values
    @JsonProperty("underline")
    UNDERLINE,
    @JsonProperty("outline")
    OUTLINE;
  }

}
