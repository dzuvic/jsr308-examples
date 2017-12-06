package de.w11k.jsr308.examples;

import org.checkerframework.checker.formatter.qual.Format;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import static org.checkerframework.checker.formatter.qual.ConversionCategory.FLOAT;
import static org.checkerframework.checker.formatter.qual.ConversionCategory.GENERAL;

/**
 * Copyright 2016 Dragan Zuvic
 */
public class FormatterDemo {
    public static void main(String[] args) {
        String str = "str";
        @Nullable String strN = null;

        String format="%s";
        String twoformat="%s %f";

        String s1 = String.format("%s", str);
        String s_checkedBy = formatMe(twoformat, str, 1.0f);


        // this may be a bug in the checker frame work. String.format return a null in this case.
        @NonNull String s_errorNull = String.format("%s", strN);

        //the following will not compile
//        String s_errorWrongType = String.format("%d", "one.zero");
//        String s_errorNoArgs = String.format("%s %s", str);
//
//        String s_errorwrongFormat = String.format(twoformat, str, str);
//        String s_errorwrongFormat2 = formatMe(twoformat, str, 1.0f);


    }

    private static String formatMe(@Format({GENERAL, FLOAT}) String formatStr, String pS, float pN) {
        return String.format(formatStr, pS, pN);
    }
}
