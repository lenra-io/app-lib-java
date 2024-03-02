package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Locale {
  // Fields
  private String countryCode;
  private String languageCode;
  private String scriptCode;
}
