package de.w11k.jsr308.examples.nulls;

import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.dataflow.qual.Pure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Copyright 2016 Dragan Zuvic
 */
public class QueueDelegate {
    private final @NonNull Queue<@NonNull Integer> queue = new LinkedList<>();

    @EnsuresNonNullIf(expression="pop()", result=false)
    @SuppressWarnings("contracts.conditional.postcondition.not.satisfied")  // Issue #399
    @Pure
    public boolean isEmpty() {
        return  this.queue.isEmpty();
    }


    @Nullable
    public Integer pop() {
        return this.isEmpty() ? null :  this.queue.poll();
    }

    public void push(@NonNull Integer a) {
        queue.add(a);
    }

}
