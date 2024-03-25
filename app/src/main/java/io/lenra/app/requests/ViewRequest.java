package io.lenra.app.requests;

import io.lenra.app.AppRequest;
import java.util.List;
import java.util.Map;

public class ViewRequest extends ViewRequestBase implements AppRequest {

  // Constructors
  public ViewRequest() {
    super();
  }

  public ViewRequest(String view) {
    this.setView(view);
  }

  public ViewRequest(String view, List<Map<String, Object>> data, Map<String, Object> props, Map<String, Object> context) {
    super();
    this.setView(view);
    this.setData(data);
    this.setProps(props);
    this.setContext(context);
  }


  // Methods
  public ViewRequest view(String view) {
    this.setView(view);
    return this;
  }

  public ViewRequest data(List<Map<String, Object>> data) {
    this.setData(data);
    return this;
  }

  public ViewRequest props(Map<String, Object> props) {
    this.setProps(props);
    return this;
  }

  public ViewRequest context(Map<String, Object> context) {
    this.setContext(context);
    return this;
  }

}
