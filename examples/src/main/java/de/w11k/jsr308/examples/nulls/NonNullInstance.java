package de.w11k.jsr308.examples.nulls;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Copyright 2016 Dragan Zuvic
 */
public class NonNullInstance {


    final @NonNull Object nn;

    final List<@NonNull String> list = new ArrayList<String>();

    public NonNullInstance(@NonNull Object nn, String ... entries) {
        this.nn = nn;
        this.list.addAll(Arrays.asList(entries));
    }
}
