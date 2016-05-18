package de.w11k.jsr308.examples;


import de.w11k.jsr308.checkers.encrypt.Encrypted;


public class SubTypingSample {
    private final int OFFSET = 13;

    // Won't compile
//    @Encrypted String enrypted="look it's unencrypted";

    public @Encrypted String encrypt(String text) {
        @Encrypted String encryptedText = new @Encrypted String();
        for (char character : text.toCharArray()) {
            encryptedText += encryptCharacter(character);
        }
        return encryptedText;
    }

    // suppress because it's encrypted
    @SuppressWarnings("encrypted")
    private @Encrypted char encryptCharacter(char character) {
        @Encrypted int encryptInt = (character + OFFSET) % Character.MAX_VALUE;
        return (@Encrypted char) encryptInt;
    }

    // Only send encrypted data!
    public void sendOverInternet(@Encrypted String msg) {
        System.out.println(String.format("sending %s", msg));
    }

    public void sendPassword() {
        String password = getUserPassword();
        sendOverInternet(
//                password
                encrypt(password)
        );
    }

    private String getUserPassword() {
        return "!@#$Really Good Password**";
    }
}
