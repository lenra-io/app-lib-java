package io.lenra.app;


public class Manifest extends ManifestBase {

  // Constructors
  public Manifest() {
    super();
  }

  public Manifest(Exposer lenra, Exposer json) {
    super();
    this.setLenra(lenra);
    this.setJson(json);
  }


  // Methods
  public Manifest lenra(Exposer lenra) {
    this.setLenra(lenra);
    return this;
  }

  public Manifest json(Exposer json) {
    this.setJson(json);
    return this;
  }

}
