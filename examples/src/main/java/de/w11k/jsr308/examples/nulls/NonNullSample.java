package de.w11k.jsr308.examples.nulls;

import org.checkerframework.checker.nullness.qual.NonNull;

public class NonNullSample {
    public static void main(String[] args) {

        NonNullInstance noErrorInstance = new NonNullInstance("hello");

//        NonNullInstance nothingInItIsNull = new NonNullInstance(null);
//
//        NonNullInstance nothingInItIsNullList = new NonNullInstance("some", null, null);


        QueueDelegate dlg = new QueueDelegate();
        @NonNull Integer doesCompile = dlg.isEmpty() ? 0 : dlg.pop();
//        @NonNull Integer doesNotCompile = dlg.pop();
    }
}
