package io.lenra.app.components.styles;

import java.util.List;

public class StrutStyle extends StrutStyleBase {

  // Constructors
  public StrutStyle() {
    super();
  }

  public StrutStyle(String debugLabel, String fontFamily, List<String> fontFamilyFallback, Double fontSize, String fontWeight, Boolean forceStrutHeight, Double height, Double leading, TextLeadingDitribution leadingDistribution) {
    super();
    this.setDebugLabel(debugLabel);
    this.setFontFamily(fontFamily);
    this.setFontFamilyFallback(fontFamilyFallback);
    this.setFontSize(fontSize);
    this.setFontWeight(fontWeight);
    this.setForceStrutHeight(forceStrutHeight);
    this.setHeight(height);
    this.setLeading(leading);
    this.setLeadingDistribution(leadingDistribution);
  }


  // Methods
  public StrutStyle debugLabel(String debugLabel) {
    this.setDebugLabel(debugLabel);
    return this;
  }

  public StrutStyle fontFamily(String fontFamily) {
    this.setFontFamily(fontFamily);
    return this;
  }

  public StrutStyle fontFamilyFallback(List<String> fontFamilyFallback) {
    this.setFontFamilyFallback(fontFamilyFallback);
    return this;
  }

  public StrutStyle fontSize(Double fontSize) {
    this.setFontSize(fontSize);
    return this;
  }

  public StrutStyle fontWeight(String fontWeight) {
    this.setFontWeight(fontWeight);
    return this;
  }

  public StrutStyle forceStrutHeight(Boolean forceStrutHeight) {
    this.setForceStrutHeight(forceStrutHeight);
    return this;
  }

  public StrutStyle height(Double height) {
    this.setHeight(height);
    return this;
  }

  public StrutStyle leading(Double leading) {
    this.setLeading(leading);
    return this;
  }

  public StrutStyle leadingDistribution(TextLeadingDitribution leadingDistribution) {
    this.setLeadingDistribution(leadingDistribution);
    return this;
  }

}
