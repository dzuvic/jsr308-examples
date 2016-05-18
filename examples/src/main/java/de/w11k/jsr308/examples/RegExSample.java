package de.w11k.jsr308.examples;

import org.checkerframework.checker.regex.RegexUtil;
import org.checkerframework.checker.regex.qual.Regex;
import org.checkerframework.dataflow.qual.SideEffectFree;

import java.util.regex.Pattern;

/**
 * Copyright 2016 Dragan Zuvic
 */
public class RegExSample {
    public final static String parenOpen = "(";

    public void doSometing() {
        String thePattern = "[a-z]+";

        // @RegEx is inferred, so the following would not compile
//        thePattern = "invalidPattern" + parenOpen;
//        thePattern = thePattern + parenOpen;
        Pattern compiledPattern = Pattern.compile(thePattern);
    }
}
