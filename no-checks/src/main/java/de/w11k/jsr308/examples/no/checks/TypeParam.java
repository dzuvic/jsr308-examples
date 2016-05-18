package de.w11k.jsr308.examples.no.checks;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright 2016 Dragan Zuvic
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_PARAMETER})
public @interface TypeParam {
}
