package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.SliderStyle;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Slider implements LenraComponent {
  // Fields
  private Boolean autofocus;
  private Double divisions;
  private String label;
  private Double max;
  private Double min;
  private String name;
  private Listener onChanged;
  private Listener onChangeEnd;
  private Listener onChangeStart;
  private SliderStyle style;
  @JsonProperty("_type")
  private final String type = "slider";
  private Double value;
}
