package io.lenra.app.components;


public class Form extends FormBase implements LenraComponent {

  // Constructors
  public Form() {
    super();
  }

  public Form(LenraComponent child) {
    this.setChild(child);
  }

  public Form(LenraComponent child, Listener onSubmit) {
    super();
    this.setChild(child);
    this.setOnSubmit(onSubmit);
  }


  // Methods
  public Form child(LenraComponent child) {
    this.setChild(child);
    return this;
  }

  public Form onSubmit(Listener onSubmit) {
    this.setOnSubmit(onSubmit);
    return this;
  }

}
