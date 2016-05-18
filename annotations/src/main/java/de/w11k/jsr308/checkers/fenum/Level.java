package de.w11k.jsr308.checkers.fenum;

import org.checkerframework.checker.fenum.qual.FenumTop;
import org.checkerframework.framework.qual.SubtypeOf;

import java.lang.annotation.*;

/**
 * Copyright 2016 Dragan Zuvic
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@SubtypeOf(FenumTop.class)
public @interface Level {
}
