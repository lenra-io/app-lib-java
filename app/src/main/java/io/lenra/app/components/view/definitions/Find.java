package io.lenra.app.components.view.definitions;

import io.lenra.app.data.Options;
import java.util.Map;

public class Find extends FindBase {

  // Constructors
  public Find() {
    super();
  }

  public Find(String coll, Map<String, Object> query) {
    this.setColl(coll);
    this.setQuery(query);
  }

  public Find(String coll, Map<String, Object> query, Map<String, Object> projection, Options options) {
    super();
    this.setColl(coll);
    this.setQuery(query);
    this.setProjection(projection);
    this.setOptions(options);
  }


  // Methods
  public Find coll(String coll) {
    this.setColl(coll);
    return this;
  }

  public Find query(Map<String, Object> query) {
    this.setQuery(query);
    return this;
  }

  public Find projection(Map<String, Object> projection) {
    this.setProjection(projection);
    return this;
  }

  public Find options(Options options) {
    this.setOptions(options);
    return this;
  }

}
