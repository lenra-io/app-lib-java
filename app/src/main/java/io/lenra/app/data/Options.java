package io.lenra.app.data;

import java.util.Map;

public class Options extends OptionsBase {

  // Constructors
  public Options() {
    super();
  }

  public Options(Integer limit, Integer skip, Map<String, Object> sort) {
    super();
    this.setLimit(limit);
    this.setSkip(skip);
    this.setSort(sort);
  }


  // Methods
  public Options limit(Integer limit) {
    this.setLimit(limit);
    return this;
  }

  public Options skip(Integer skip) {
    this.setSkip(skip);
    return this;
  }

  public Options sort(Map<String, Object> sort) {
    this.setSort(sort);
    return this;
  }

}
