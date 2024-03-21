package io.lenra.app.components;


public class OverlayEntry extends OverlayEntryBase implements LenraComponent {

  // Constructors
  public OverlayEntry() {
    super();
  }

  public OverlayEntry(LenraComponent child) {
    this.setChild(child);
  }

  public OverlayEntry(LenraComponent child, Boolean maintainState, Boolean opaque, Boolean showOverlay) {
    super();
    this.setChild(child);
    this.setMaintainState(maintainState);
    this.setOpaque(opaque);
    this.setShowOverlay(showOverlay);
  }


  // Methods
  public OverlayEntry child(LenraComponent child) {
    this.setChild(child);
    return this;
  }

  public OverlayEntry maintainState(Boolean maintainState) {
    this.setMaintainState(maintainState);
    return this;
  }

  public OverlayEntry opaque(Boolean opaque) {
    this.setOpaque(opaque);
    return this;
  }

  public OverlayEntry showOverlay(Boolean showOverlay) {
    this.setShowOverlay(showOverlay);
    return this;
  }

}
