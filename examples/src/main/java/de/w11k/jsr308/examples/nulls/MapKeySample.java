package de.w11k.jsr308.examples.nulls;

import org.checkerframework.checker.nullness.qual.KeyFor;
import org.checkerframework.dataflow.qual.SideEffectFree;

import java.util.HashMap;
import java.util.Map;

/**
 * Modified Example from manual..
 */
public class MapKeySample {

    Map<String, Object> themap;

    // The type of key defaults to @UnknownKeyFor String
    private String key;

    public MapKeySample() {
        this.themap = new HashMap<String, Object>();
        key = "theKey";
    }

    public void myMethod() {
        @KeyFor("themap") String km;
        if (themap.containsKey(key)) {
            km = key;
            sideEffectFreeMethod();
            km = key;

            otherMethod();

            //fails: found: String, required: @KeyFor("this.themap") String
//            km = key; //
        }
    }

    @SideEffectFree
    private void sideEffectFreeMethod() {
    }

    private void otherMethod() {
    }
}

