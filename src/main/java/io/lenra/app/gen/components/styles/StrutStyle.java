package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StrutStyle {
  // Fields
  private String debugLabel;
  private String fontFamily;
  private ArrayList<String> fontFamilyFallback;
  private Double fontSize;
  private String fontWeight;
  private Boolean forceStrutHeight;
  private Double height;
  private Double leading;
  private TextLeadingDitribution leadingDistribution;
}
