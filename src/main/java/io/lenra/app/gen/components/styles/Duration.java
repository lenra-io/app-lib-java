package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Duration {
  // Fields
  private Integer days;
  private Integer hours;
  private Integer microseconds;
  private Integer milliseconds;
  private Integer minutes;
  private Integer seconds;
}
