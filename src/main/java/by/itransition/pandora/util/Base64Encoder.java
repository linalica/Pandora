package by.itransition.pandora.util;

import java.util.Base64;

public class Base64Encoder {

    private Base64Encoder() {
    }

    public static String encode(byte[] src) {
        return Base64.getEncoder().encodeToString(src);
    }

}
