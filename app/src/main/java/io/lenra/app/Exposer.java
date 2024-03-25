package io.lenra.app;

import java.util.List;

public class Exposer extends ExposerBase {

  // Constructors
  public Exposer() {
    super();
  }

  public Exposer(List<Route> routes) {
    this.setRoutes(routes);
  }

  public Exposer(String version, List<Route> routes) {
    super();
    this.setVersion(version);
    this.setRoutes(routes);
  }


  // Methods
  public Exposer version(String version) {
    this.setVersion(version);
    return this;
  }

  public Exposer routes(List<Route> routes) {
    this.setRoutes(routes);
    return this;
  }

}
