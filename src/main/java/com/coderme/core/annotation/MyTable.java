package com.coderme.core.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({TYPE}) @Retention(RUNTIME)
public @interface MyTable {
	/**
	 * The name of the table.
	 *
	 * Defaults to the entity name.
	 */
	String name() default "";
}
