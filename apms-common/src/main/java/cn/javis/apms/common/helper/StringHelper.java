package cn.javis.apms.common.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class StringHelper {

    /*
     * generate 128bit Md5 Message Digest
     */
    public static byte[] toMd5(String content) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            return md5.digest(content.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * convert byte[] to human-readable String in Hex form
     */
    public static String byte2Hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /*
     * convert String in Hex form to byte[]
     */
    public static byte[] hex2Byte(String hex) {
        if (hex.isEmpty())
            return null;
        byte[] bytes = new byte[hex.length() / 2];
        try {
            for (int i = 0; i < hex.length(); i = i + 2) {
                int highBit = Integer.parseInt(hex.substring(i, i + 1), 16);
                int lowBit = Integer.parseInt(hex.substring(i + 1, i + 2), 16);
                bytes[i / 2] = (byte) (highBit * 16 + lowBit);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            bytes = null;
        }
        return bytes;
    }
}
