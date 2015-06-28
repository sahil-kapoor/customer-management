package cn.javis.apms.server.helper;

import java.nio.charset.Charset;
import java.util.List;

import cn.javis.apms.common.aes.AesEncrypt;
import cn.javis.apms.common.aes.exception.CryptionFailException;
import cn.javis.apms.common.helper.StringHelper;
import cn.javis.apms.common.helper.exception.StringWrongFormatException;
import cn.javis.apms.common.jackson.JacksonUtils;
import cn.javis.apms.server.domain.AuthorityInfo;

import com.fasterxml.jackson.core.JsonProcessingException;

public final class AesCryptUtils {
    public static String encrypt(Object object, AuthorityInfo authoInfo) throws JsonProcessingException,
            CryptionFailException, StringWrongFormatException {
        String content = JacksonUtils.object2String(object);
        String encrypted = StringHelper.byte2Hex(AesEncrypt.encrypt(content, authoInfo.getAccessKey()));
        return encrypted;
    }

    public static <T> T decrypt(String content, Class<T> valueType, AuthorityInfo authoInfo)
            throws CryptionFailException, StringWrongFormatException {
        String decrypted = new String(AesEncrypt.decrypt(StringHelper.hex2Byte(content), authoInfo.getAccessKey()),
                Charset.defaultCharset());
        T t = JacksonUtils.string2Object(decrypted, valueType);
        return t;
    }

    public static <T> List<T> decryptList(String content, Class<T> valueType, AuthorityInfo authoInfo)
            throws CryptionFailException, StringWrongFormatException {
        String decrypted = new String(AesEncrypt.decrypt(StringHelper.hex2Byte(content), authoInfo.getAccessKey()),
                Charset.defaultCharset());
        List<T> results = JacksonUtils.string2ObjectList(decrypted, valueType);
        return results;
    }
}
