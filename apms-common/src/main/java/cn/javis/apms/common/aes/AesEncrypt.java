package cn.javis.apms.common.aes.helper;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AesEncrypt {

    private static byte[] encrypt(String unCoded, String password) throws NoSuchAlgorithmException,
    NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom(password.getBytes()));
        SecretKey secretKey = keyGenerator.generateKey();
        System.out.println(secretKey.getFormat());
        byte[] encodeFormat = secretKey.getEncoded();
//        System.out.println(parseByte2Hex(encodeFormat).length());
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        SecretKeySpec key = new SecretKeySpec(md5.digest(password.getBytes()), "AES");
        System.out.println(parseByte2Hex(md5.digest(password.getBytes())));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(unCoded.getBytes());
    }

    private static byte[] decrypt(byte[] coded, String password) throws NoSuchAlgorithmException,
    NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom(password.getBytes()));
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] encodeFormat = secretKey.getEncoded();

        MessageDigest md5 = MessageDigest.getInstance("MD5");
//        System.out.println(parseByte2Hex(encodeFormat).length());
        SecretKeySpec key = new SecretKeySpec(md5.digest(password.getBytes()), "AES");
        System.out.println(parseByte2Hex(md5.digest(password.getBytes())));
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(coded);
    }

    public static String parseByte2Hex(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] parseHex2Byte(String hexStr) {
        if (hexStr.length() < 1) return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        String content = "test";
        String password = "12345678";
        //加密   
        System.out.println("加密前："
                + content);
        try {
            byte[] encryptResult = encrypt(content, password);
//             byte[] decryptResult = decrypt(encryptResult, password);
//            System.out.println("解密后："
//                    + new String(decryptResult));
            String encryptResultStr = parseByte2Hex(encryptResult);
//            Thread.sleep(50000);
            System.out.println("加密后："
                    + encryptResultStr);
            //解密   
            byte[] decryptFrom = parseHex2Byte(encryptResultStr);
            byte[] decryptResult = decrypt(decryptFrom, password);
            System.out.println("解密后："
                    + new String(decryptResult));

        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
