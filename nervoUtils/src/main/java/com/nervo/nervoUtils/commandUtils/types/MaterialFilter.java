package com.nervo.nervoUtils.commandUtils.types;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MaterialFilter {
	public boolean damegable() default false;
}
