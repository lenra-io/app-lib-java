package io.lenra.app.components.view.definitions;

import io.lenra.app.api.DataApi;
import io.lenra.app.data.Data;
import io.lenra.app.data.Options;
import java.util.Map;

public class Find extends FindBase {

  // Constructors
  public Find() {
    super();
  }

  public <D extends Data> Find(Class<D> collClass, Map<String, Object> query) {
    this(DataApi.collectionName(collClass), query);
  }

  public Find(String coll, Map<String, Object> query) {
    this.setColl(coll);
    this.setQuery(query);
  }

  public <D extends Data> Find(Class<D> collClass, Map<String, Object> query, Map<String, Object> projection, Options options) {
    this(DataApi.collectionName(collClass), query, projection, options);
  }

  public Find(String coll, Map<String, Object> query, Map<String, Object> projection, Options options) {
    super();
    this.setColl(coll);
    this.setQuery(query);
    this.setProjection(projection);
    this.setOptions(options);
  }


  // Methods
  public <D extends Data> Find coll(Class<D> collClass) {
    return this.coll(DataApi.collectionName(collClass));
  }
	
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
