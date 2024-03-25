package io.lenra.app.components;

import java.util.Map;

import io.lenra.app.listener.ListenerName;

public class Listener extends ListenerBase {

	// Constructors
	public Listener() {
		super();
	}

	public Listener(ListenerName name) {
		this(name.value);
	}

	public Listener(String name) {
		this.setName(name);
	}

	public Listener(ListenerName name, Map<String, Object> props) {
		this(name.value, props);
	}

	public Listener(String name, Map<String, Object> props) {
		super();
		this.setName(name);
		this.setProps(props);
	}

	// Methods
	public Listener name(ListenerName name) {
		return this.name(name.value);
	}

	public Listener name(String name) {
		this.setName(name);
		return this;
	}

	public Listener props(Map<String, Object> props) {
		this.setProps(props);
		return this;
	}

}
