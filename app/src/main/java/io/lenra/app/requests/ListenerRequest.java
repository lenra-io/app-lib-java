package io.lenra.app.requests;

import io.lenra.app.AppRequest;
import io.lenra.app.requests.listener.definitions.ApiInformations;
import java.util.Map;

public class ListenerRequest extends ListenerRequestBase implements AppRequest {

  // Constructors
  public ListenerRequest() {
    super();
  }

  public ListenerRequest(String listener, ApiInformations api) {
    this.setListener(listener);
    this.setApi(api);
  }

  public ListenerRequest(String listener, Map<String, Object> props, Map<String, Object> event, ApiInformations api) {
    super();
    this.setListener(listener);
    this.setProps(props);
    this.setEvent(event);
    this.setApi(api);
  }


  // Methods
  public ListenerRequest listener(String listener) {
    this.setListener(listener);
    return this;
  }

  public ListenerRequest props(Map<String, Object> props) {
    this.setProps(props);
    return this;
  }

  public ListenerRequest event(Map<String, Object> event) {
    this.setEvent(event);
    return this;
  }

  public ListenerRequest api(ApiInformations api) {
    this.setApi(api);
    return this;
  }

}
