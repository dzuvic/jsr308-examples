package de.w11k.jsr308.examples;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.checkerframework.checker.interning.qual.Interned;

import java.util.concurrent.ExecutionException;

/**
 * Copyright 2016 Dragan Zuvic
 */
public class InterningSample {


    private static final LoadingCache<Integer, @Interned Integer> internedInteger = CacheBuilder
            .newBuilder()
            .weakValues()
           .build(
               new CacheLoader<Integer, @Interned Integer>() {
                 public @Interned Integer load(Integer key) {
                   return new @Interned Integer(key);
                 }
               });

    @Interned
    public static Integer intern(Integer a) throws ExecutionException {
            return internedInteger.get(a);
    }

    public static @Interned String intern(String s) {
        return s.intern();
    }


    public static void main(String... args) throws  Exception{

        @Interned String s1 = "10";
        @Interned String s1_same = intern(new String("10"));

        // Fails to compile
//          @Interned String s1_same = new String("10");

        if (s1 == s1_same) System.out.println("same string");
        else System.out.println("not same string");


        @Interned Integer i = intern(10000);
        @Interned Integer i_same = intern(10000);
//         does not compile
//        Integer i = 1000;
//        Integer i_same = 10000;


        if (i == i_same) System.out.println("same number");
        else System.out.println("not same number");
    }

}
