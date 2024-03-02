package io.lenra.app.gen.components;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.lenra.app.gen.components.styles.CarouselOptions;
import java.util.ArrayList;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Carousel implements LenraComponent {
  // Fields
  private ArrayList<LenraComponent> children;
  private CarouselOptions options;
  @JsonProperty("_type")
  private final String type = "carousel";
}
