package cn.javis.apms.common.aes;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import cn.javis.apms.common.helper.StringHelper;

public class AesEncrypt {

    private static byte[] encrypt(String unCoded, String strKey) {
        SecretKeySpec key = new SecretKeySpec(StringHelper.toMd5(strKey), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(unCoded.getBytes());
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] decrypt(byte[] coded, String strKey) {
        SecretKeySpec key = new SecretKeySpec(StringHelper.toMd5(strKey), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(coded);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;

    }

    /*
     * Use md5 to generate a key for encryp/decrypt by username, randomNumber
     * and password.
     * 
     * The return value can be passed to `strKey` of encrypt/decrypt function.
     */
    public String composeAccessKey(String usernameMd5, String randomNumberMd5, String passwordMd5) {
        StringBuilder sb = new StringBuilder();
        sb.append(usernameMd5);
        sb.append(randomNumberMd5);
        sb.append(passwordMd5);
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        String content = "userpassworkd";
        String password = "346905F4AB5F088962FD90CB75ED95FC";
        // 加密
        System.out.println("加密前：" + content);
        byte[] encryptResult = encrypt(content, password);
        // byte[] decryptResult = decrypt(encryptResult, password);
        // System.out.println("解密后："
        // + new String(decryptResult));
        String encryptResultStr = StringHelper.byte2Hex(encryptResult);

        System.out.println("加密后：" + encryptResultStr);
        // 解密
        byte[] decryptFrom = StringHelper.hex2Byte(encryptResultStr);
        byte[] decryptResult = decrypt(decryptFrom, password);
        System.out.println("解密后：" + new String(decryptResult));

    }
}
