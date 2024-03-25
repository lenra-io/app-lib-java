package io.lenra.app;

import io.lenra.app.components.View;
import java.util.List;

public class Route extends RouteBase {

  // Constructors
  public Route() {
    super();
  }

  public Route(String path, View view) {
    this.setPath(path);
    this.setView(view);
  }

  public Route(String path, View view, List<String> roles) {
    super();
    this.setPath(path);
    this.setView(view);
    this.setRoles(roles);
  }


  // Methods
  public Route path(String path) {
    this.setPath(path);
    return this;
  }

  public Route view(View view) {
    this.setView(view);
    return this;
  }

  public Route roles(List<String> roles) {
    this.setRoles(roles);
    return this;
  }

}
