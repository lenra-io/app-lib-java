package io.lenra.app.requests.listener.definitions;


public class ApiInformations extends ApiInformationsBase {

  // Constructors
  public ApiInformations() {
    super();
  }

  public ApiInformations(String url, String token) {
    this.setUrl(url);
    this.setToken(token);
  }


  // Methods
  public ApiInformations url(String url) {
    this.setUrl(url);
    return this;
  }

  public ApiInformations token(String token) {
    this.setToken(token);
    return this;
  }

}
