package io.lenra.app.components.styles;


public class Locale extends LocaleBase {

  // Constructors
  public Locale() {
    super();
  }

  public Locale(String countryCode, String languageCode, String scriptCode) {
    super();
    this.setCountryCode(countryCode);
    this.setLanguageCode(languageCode);
    this.setScriptCode(scriptCode);
  }


  // Methods
  public Locale countryCode(String countryCode) {
    this.setCountryCode(countryCode);
    return this;
  }

  public Locale languageCode(String languageCode) {
    this.setLanguageCode(languageCode);
    return this;
  }

  public Locale scriptCode(String scriptCode) {
    this.setScriptCode(scriptCode);
    return this;
  }

}
