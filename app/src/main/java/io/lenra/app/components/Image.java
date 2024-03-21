package io.lenra.app.components;

import io.lenra.app.components.styles.Alignment;
import io.lenra.app.components.styles.BoxFit;
import io.lenra.app.components.styles.FilterQuality;
import io.lenra.app.components.styles.ImageRepeat;
import io.lenra.app.components.styles.Rect;

public class Image extends ImageBase implements LenraComponent {

  // Constructors
  public Image() {
    super();
  }

  public Image(String src) {
    this.setSrc(src);
  }

  public Image(String src, Double width, Double height, Alignment alignment, Rect centerSlice, LenraComponent errorPlaceholder, Boolean excludeFromSemantics, FilterQuality filterQuality, BoxFit fit, LenraComponent framePlaceholder, Boolean gaplessPlayback, Boolean isAntiAlias, LenraComponent loadingPlaceholder, ImageRepeat repeat, String semanticLabel) {
    super();
    this.setSrc(src);
    this.setWidth(width);
    this.setHeight(height);
    this.setAlignment(alignment);
    this.setCenterSlice(centerSlice);
    this.setErrorPlaceholder(errorPlaceholder);
    this.setExcludeFromSemantics(excludeFromSemantics);
    this.setFilterQuality(filterQuality);
    this.setFit(fit);
    this.setFramePlaceholder(framePlaceholder);
    this.setGaplessPlayback(gaplessPlayback);
    this.setIsAntiAlias(isAntiAlias);
    this.setLoadingPlaceholder(loadingPlaceholder);
    this.setRepeat(repeat);
    this.setSemanticLabel(semanticLabel);
  }


  // Methods
  public Image src(String src) {
    this.setSrc(src);
    return this;
  }

  public Image width(Double width) {
    this.setWidth(width);
    return this;
  }

  public Image height(Double height) {
    this.setHeight(height);
    return this;
  }

  public Image alignment(Alignment alignment) {
    this.setAlignment(alignment);
    return this;
  }

  public Image centerSlice(Rect centerSlice) {
    this.setCenterSlice(centerSlice);
    return this;
  }

  public Image errorPlaceholder(LenraComponent errorPlaceholder) {
    this.setErrorPlaceholder(errorPlaceholder);
    return this;
  }

  public Image excludeFromSemantics(Boolean excludeFromSemantics) {
    this.setExcludeFromSemantics(excludeFromSemantics);
    return this;
  }

  public Image filterQuality(FilterQuality filterQuality) {
    this.setFilterQuality(filterQuality);
    return this;
  }

  public Image fit(BoxFit fit) {
    this.setFit(fit);
    return this;
  }

  public Image framePlaceholder(LenraComponent framePlaceholder) {
    this.setFramePlaceholder(framePlaceholder);
    return this;
  }

  public Image gaplessPlayback(Boolean gaplessPlayback) {
    this.setGaplessPlayback(gaplessPlayback);
    return this;
  }

  public Image isAntiAlias(Boolean isAntiAlias) {
    this.setIsAntiAlias(isAntiAlias);
    return this;
  }

  public Image loadingPlaceholder(LenraComponent loadingPlaceholder) {
    this.setLoadingPlaceholder(loadingPlaceholder);
    return this;
  }

  public Image repeat(ImageRepeat repeat) {
    this.setRepeat(repeat);
    return this;
  }

  public Image semanticLabel(String semanticLabel) {
    this.setSemanticLabel(semanticLabel);
    return this;
  }

}
