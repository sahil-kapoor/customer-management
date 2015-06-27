package cn.javis.apms.common.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import cn.javis.apms.common.ReturnCode;
import cn.javis.apms.common.aes.exception.CryptionFailException;
import cn.javis.apms.common.helper.StringHelper;
import cn.javis.apms.common.helper.exception.StringWrongFormatException;

public class AesEncrypt {

    /*
     * Use md5 to generate a key for encryp/decrypt by username, randomNumber
     * and password.
     * 
     * The return value can be passed to `strKey` of encrypt/decrypt function.
     */
    public static String composeAccessKey(String usernameMd5, String randomKeyMd5, String passwordMd5) {
        StringBuilder sb = new StringBuilder();
        sb.append(usernameMd5);
        sb.append(randomKeyMd5);
        sb.append(passwordMd5);
        return StringHelper.toMd5(sb.toString());
    }

    public static byte[] encrypt(String unCoded, String keyMd5) throws CryptionFailException, StringWrongFormatException {
        SecretKeySpec key = new SecretKeySpec(StringHelper.hex2Byte(keyMd5), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(unCoded.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CryptionFailException(ReturnCode.ENCRYPT_FAIL);
        }
    }

    public static byte[] decrypt(byte[] coded, String keyMd5) throws CryptionFailException, StringWrongFormatException {
        SecretKeySpec key = new SecretKeySpec(StringHelper.hex2Byte(keyMd5), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(coded);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CryptionFailException(ReturnCode.DECRYPT_FAIL);
        }
    }

    public static void main(String[] args) throws CryptionFailException, StringWrongFormatException {
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
        byte[] decryptFrom = StringHelper
                .hex2Byte("075C12A5084927286CF79E47437E8F6CB10DC3FC639CE2F54DEB5A588204D884E2B2CDDD39216A64450745EE3950E110");
        byte[] decryptResult = decrypt(decryptFrom, "24694FDF7737B9F6B4BED7DD52DBA881");
        System.out.println("解密后：" + new String(decryptResult));

    }
}
