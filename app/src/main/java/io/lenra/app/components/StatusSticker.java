package io.lenra.app.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.processing.Generated;

public class StatusSticker extends StatusStickerBase implements LenraComponent {

  // Constructors
  public StatusSticker() {
    super();
  }

  public StatusSticker(StatusSticker.Status  status) {
    this.setStatus(status);
  }


  // Methods
  public StatusSticker status(StatusSticker.Status  status) {
    this.setStatus(status);
    return this;
  }


  // Sub elements

  @Generated("JSON Schema")
  public static enum Status  {
    // Values
    @JsonProperty("success")
    SUCCESS,
    @JsonProperty("warning")
    WARNING,
    @JsonProperty("error")
    ERROR,
    @JsonProperty("pending")
    PENDING;
  }

}
