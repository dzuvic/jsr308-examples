package de.w11k.jsr308.examples;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.tainting.qual.Tainted;
import org.checkerframework.checker.tainting.qual.Untainted;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.Console;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import static de.w11k.jsr308.examples.PasswordHasher.hashPassword;

/**
 * Copyright 2016 Dragan Zuvic
 */
public class TaintedSample {


    public static void main(String[] args) throws Exception {
        final Console console = System.console();

        // Note: try use char[]
        final @Tainted @Nullable String password;
        if (console==null) {
            System.out.println("Could not get JVM console. Assuming something as password");
            password = "passoword";

        }
        else password = console.readLine("Password:");

        boolean passwordCorrect = checkPassword(hashPassword(password));
//        boolean passwordCorrect = checkPassword(password);


        if (passwordCorrect)
            System.out.println("user logged in");
        else
            System.out.println("user rejected");
    }

    public static String readPasswordFromDB() {
        return "VlZTDW+nmaymcCl8HCT2r0oxnKNr/xq1xUmWYfcA9bQ=";
    }

    @NonNull
    private static boolean checkPassword(@Untainted @Nullable String password) throws Exception {
        @NonNull String nonNullPass = password == null ? "" : password;

        return nonNullPass.equals(readPasswordFromDB());
    }
}

class PasswordHasher {


    private static final byte[] SALT = new byte[]{51, 72, 127, -3, -50, 33, 20, -80, 0, 31,
            -4, -2, 120, 47, -56, 43, -98, -76, -101, 25,
            -80, 0, 31, -4, -2, 120, 47, -56, 43, -98,
            32, -42};
    private static final int ITERATIONS = 25;
    private static final int KEY_LENGTH = 256;

    @Untainted
    @NonNull
    public static String hashPassword(@Nullable String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (password == null) {
            return "";
        }
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), SALT, ITERATIONS, KEY_LENGTH);
        SecretKey key = skf.generateSecret(spec);
        byte[] res = key.getEncoded();

        @SuppressWarnings({"tainting"})
        @Untainted String result = Base64.getEncoder().encodeToString(res);
        return result;
    }
}


