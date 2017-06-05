package com.architecturecomponents.network;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Stores provided keys for easy access. NOTE; This should be moved to a keystore when appropriate.
 */

public class StaticKeys {
    private String apiKey = "54306733de0f5cd1418aa05a85fa062a";
    private String privateKey = "5de1fabcda2ea08912bd8b09bca4321f50563655"; // NOTE; Should be in keystore if non-example app

    public String getApiKey() {
        return apiKey;
    }

    public String getHash(String timeStamp) {
        return generateMd5(String.format("%s%s%s", timeStamp, privateKey, apiKey));
    }

    private final String generateMd5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
