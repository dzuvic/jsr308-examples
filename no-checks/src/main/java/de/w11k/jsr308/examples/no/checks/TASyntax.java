package de.w11k.jsr308.examples.no.checks;

import org.w3c.dom.Document;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * Places to put type annotations
 *
 * Copyright 2016 Dragan Zuvic
 */
public class TASyntax<@TypeParam T extends @TypeUse Number>
    implements @TypeUse Comparable  {

    Map<@TypeUse String, @TypeUse List<@TypeUse Document>> xmlDocument;

    //    type parameter bounds, e.g. wildcard:
    Collection<@TypeUse ? super @TypeUse Document> contractCollection;

    String @TypeUse [] typedArray;

    // before the simple name
    java.lang. @TypeUse Object o;

    // in Throws Clause
    public void whereToPut () throws @TypeUse IOException {
        @TypeUse Car c = new @TypeUse DirtyCar();
        // In Casts
        DirtyCar d = (@TypeUse DirtyCar & Serializable) c;

        // type tests
        boolean b = d instanceof @TypeUse Car;
    }

    public static final TASyntax<Integer> newone() {
        //  In constructors
        return new <Integer> @TypeUse TASyntax();
    }

    public <@TypeParam X extends T> void specialBound ( X x ) {}

    // receiver syntax to annotate the type of this
    @Override
    public int compareTo(@TypeUse TASyntax<T> this, Object o) {
        return 0;
    }

}

class Car {}
class DirtyCar extends Car {}


