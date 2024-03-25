package io.lenra.app.components.styles;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.processing.Generated;

public class CarouselOptions extends CarouselOptionsBase {

  // Constructors
  public CarouselOptions() {
    super();
  }

  public CarouselOptions(Double height, Boolean enlargeCenterPage, Boolean autoPlay, Duration autoPlayInterval, Duration autoPlayAnimationDuration, Boolean pauseAutoPlayOnTouch, Double aspectRatio, Integer initialPage, Boolean enableInfiniteScroll, Boolean reverse, Direction scrollDirection, Double viewportFraction, CarouselOptions.EnlargeStrategy  enlargeStrategy) {
    super();
    this.setHeight(height);
    this.setEnlargeCenterPage(enlargeCenterPage);
    this.setAutoPlay(autoPlay);
    this.setAutoPlayInterval(autoPlayInterval);
    this.setAutoPlayAnimationDuration(autoPlayAnimationDuration);
    this.setPauseAutoPlayOnTouch(pauseAutoPlayOnTouch);
    this.setAspectRatio(aspectRatio);
    this.setInitialPage(initialPage);
    this.setEnableInfiniteScroll(enableInfiniteScroll);
    this.setReverse(reverse);
    this.setScrollDirection(scrollDirection);
    this.setViewportFraction(viewportFraction);
    this.setEnlargeStrategy(enlargeStrategy);
  }


  // Methods
  public CarouselOptions height(Double height) {
    this.setHeight(height);
    return this;
  }

  public CarouselOptions enlargeCenterPage(Boolean enlargeCenterPage) {
    this.setEnlargeCenterPage(enlargeCenterPage);
    return this;
  }

  public CarouselOptions autoPlay(Boolean autoPlay) {
    this.setAutoPlay(autoPlay);
    return this;
  }

  public CarouselOptions autoPlayInterval(Duration autoPlayInterval) {
    this.setAutoPlayInterval(autoPlayInterval);
    return this;
  }

  public CarouselOptions autoPlayAnimationDuration(Duration autoPlayAnimationDuration) {
    this.setAutoPlayAnimationDuration(autoPlayAnimationDuration);
    return this;
  }

  public CarouselOptions pauseAutoPlayOnTouch(Boolean pauseAutoPlayOnTouch) {
    this.setPauseAutoPlayOnTouch(pauseAutoPlayOnTouch);
    return this;
  }

  public CarouselOptions aspectRatio(Double aspectRatio) {
    this.setAspectRatio(aspectRatio);
    return this;
  }

  public CarouselOptions initialPage(Integer initialPage) {
    this.setInitialPage(initialPage);
    return this;
  }

  public CarouselOptions enableInfiniteScroll(Boolean enableInfiniteScroll) {
    this.setEnableInfiniteScroll(enableInfiniteScroll);
    return this;
  }

  public CarouselOptions reverse(Boolean reverse) {
    this.setReverse(reverse);
    return this;
  }

  public CarouselOptions scrollDirection(Direction scrollDirection) {
    this.setScrollDirection(scrollDirection);
    return this;
  }

  public CarouselOptions viewportFraction(Double viewportFraction) {
    this.setViewportFraction(viewportFraction);
    return this;
  }

  public CarouselOptions enlargeStrategy(CarouselOptions.EnlargeStrategy  enlargeStrategy) {
    this.setEnlargeStrategy(enlargeStrategy);
    return this;
  }


  // Sub elements

  @Generated("JSON Schema")
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
