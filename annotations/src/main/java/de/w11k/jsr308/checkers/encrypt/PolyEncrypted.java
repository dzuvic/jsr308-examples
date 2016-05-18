package de.w11k.jsr308.checkers.encrypt;

import org.checkerframework.framework.qual.PolymorphicQualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Denotes that the representation of an object is encrypted.
 */
@PolymorphicQualifier
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface PolyEncrypted {}
