package io.lenra.app.components.styles;


public class Duration extends DurationBase {

  // Constructors
  public Duration() {
    super();
  }

  public Duration(Integer days, Integer hours, Integer minutes, Integer seconds, Integer milliseconds, Integer microseconds) {
    super();
    this.setDays(days);
    this.setHours(hours);
    this.setMinutes(minutes);
    this.setSeconds(seconds);
    this.setMilliseconds(milliseconds);
    this.setMicroseconds(microseconds);
  }


  // Methods
  public Duration days(Integer days) {
    this.setDays(days);
    return this;
  }

  public Duration hours(Integer hours) {
    this.setHours(hours);
    return this;
  }

  public Duration minutes(Integer minutes) {
    this.setMinutes(minutes);
    return this;
  }

  public Duration seconds(Integer seconds) {
    this.setSeconds(seconds);
    return this;
  }

  public Duration milliseconds(Integer milliseconds) {
    this.setMilliseconds(milliseconds);
    return this;
  }

  public Duration microseconds(Integer microseconds) {
    this.setMicroseconds(microseconds);
    return this;
  }

}
