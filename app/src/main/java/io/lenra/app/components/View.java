package io.lenra.app.components;

import java.util.Map;

import io.lenra.app.components.view.definitions.Find;
import io.lenra.app.view.ViewName;

public class View extends ViewBase implements LenraComponent {

	// Constructors
	public View() {
		super();
	}

	public View(ViewName name) {
		this(name.value);
	}

	public View(String name) {
		this.setName(name);
	}

	public View(ViewName name, Map<String, Object> props, Find find, Map<String, Object> context) {
		this(name.value, props, find, context);
	}

	public View(String name, Map<String, Object> props, Find find, Map<String, Object> context) {
		super();
		this.setName(name);
		this.setProps(props);
		this.setFind(find);
		this.setContext(context);
	}

	// Methods
	public View name(ViewName name) {
		return this.name(name.value);
	}

	public View name(String name) {
		this.setName(name);
		return this;
	}

	public View props(Map<String, Object> props) {
		this.setProps(props);
		return this;
	}

	public View find(Find find) {
		this.setFind(find);
		return this;
	}

	public View context(Map<String, Object> context) {
		this.setContext(context);
		return this;
	}

}
