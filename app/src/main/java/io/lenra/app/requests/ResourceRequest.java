package io.lenra.app.requests;

import io.lenra.app.AppRequest;

public class ResourceRequest extends ResourceRequestBase implements AppRequest {

  // Constructors
  public ResourceRequest() {
    super();
  }

  public ResourceRequest(String resource) {
    this.setResource(resource);
  }


  // Methods
  public ResourceRequest resource(String resource) {
    this.setResource(resource);
    return this;
  }

}
