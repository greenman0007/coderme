package com.coderme.core.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({METHOD, FIELD}) @Retention(RUNTIME)
public @interface MyColumn {
	/**
	 * The name of the column. Defaults to the property or field name
	 */
	String name() default "";
}
