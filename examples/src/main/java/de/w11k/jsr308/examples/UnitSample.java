package de.w11k.jsr308.examples;

import org.checkerframework.checker.units.qual.*;

/**
 * Copyright 2016 Dragan Zuvic
 */
public class UnitSample {

    static final @m int m =  new @m Integer(1);
    static final @s int s = new @s Integer(1);

    void demo() {
        @m int laenge = 5 * m;
        @s double zeit = 1 * s;

        @mPERs double mProS = laenge / zeit;

        // Fails
//        @kmPERh double kmPERhdoubleNotCompile = laenge / zeit;

        // the metrics have to be converted
        @kmPERh double kmPERhdouble = fromMeterToKm(laenge) / fromSecondToH(zeit);
    }

    @h double fromSecondToH(@s double seconds) {
        return (new @h Double(seconds) / new Double(3600)) ;
    }

    @km double fromMeterToKm(double meters) {
        return (new @km Double(meters) / new Double(1000)) ;
    }
}
