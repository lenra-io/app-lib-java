package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.Alignment;
import io.lenra.app.gen.components.styles.BoxFit;
import io.lenra.app.gen.components.styles.FilterQuality;
import io.lenra.app.gen.components.styles.ImageRepeat;
import io.lenra.app.gen.components.styles.Rect;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image implements LenraComponent {
  // Fields
  private Alignment alignment;
  private Rect centerSlice;
  private LenraComponent errorPlaceholder;
  private Boolean excludeFromSemantics;
  private FilterQuality filterQuality;
  private BoxFit fit;
  private LenraComponent framePlaceholder;
  private Boolean gaplessPlayback;
  private Double height;
  private Boolean isAntiAlias;
  private LenraComponent loadingPlaceholder;
  private ImageRepeat repeat;
  private String semanticLabel;
  private String src;
  @JsonProperty("_type")
  private final String type = "image";
  private Double width;
}
