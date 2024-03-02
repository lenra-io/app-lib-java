package io.lenra.app.gen.components.styles;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarouselOptions {
  // Fields
  private Double aspectRatio;
  private Boolean autoPlay;
  private Duration autoPlayAnimationDuration;
  private Duration autoPlayInterval;
  private Boolean enableInfiniteScroll;
  private Boolean enlargeCenterPage;
  private CarouselOptions.EnlargeStrategy  enlargeStrategy;
  private Double height;
  private Integer initialPage;
  private Boolean pauseAutoPlayOnTouch;
  private Boolean reverse;
  private Direction scrollDirection;
  private Double viewportFraction;

  // Sub elements

  public static enum EnlargeStrategy  {
    // Values
    @JsonProperty("scale")
    SCALE,
    @JsonProperty("height")
    HEIGHT,
    @JsonProperty("zoom")
    ZOOM;
  }

}