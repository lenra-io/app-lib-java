package io.lenra.app.view;

@FunctionalInterface
public interface Filler<T> {
	void fill(T t);
}
