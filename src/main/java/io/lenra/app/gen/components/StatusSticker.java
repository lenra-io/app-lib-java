package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusSticker implements LenraComponent {
  // Fields
  private StatusSticker.Status  status;
  @JsonProperty("_type")
  private final String type = "statusSticker";

  // Sub elements

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
