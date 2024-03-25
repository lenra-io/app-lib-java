package io.lenra.app.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface AppView {
	String name() default "";
	String prefix() default "";


	@Target(ElementType.PARAMETER)
	@Retention(RetentionPolicy.SOURCE)
	public static @interface Data {}

	@Target(ElementType.PARAMETER)
	@Retention(RetentionPolicy.SOURCE)
	public static @interface Props {}

	@Target(ElementType.PARAMETER)
	@Retention(RetentionPolicy.SOURCE)
	public static @interface Context {}
}
