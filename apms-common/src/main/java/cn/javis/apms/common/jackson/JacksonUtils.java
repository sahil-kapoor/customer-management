package cn.javis.apms.common.jackson;

import java.util.ArrayList;
import java.util.List;

import cn.javis.apms.common.ReturnCode;
import cn.javis.apms.common.aes.exception.CryptionFailException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JacksonUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String object2String(Object object) throws CryptionFailException {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new CryptionFailException(ReturnCode.ENCRYPT_FAIL);
        }
    }

    public static <T> T string2Object(String content, Class<T> valueType) throws CryptionFailException {
        try {
            return mapper.readValue(content, valueType);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CryptionFailException(ReturnCode.DECRYPT_FAIL);
        }
    }

    public static <T> List<T> string2ObjectList(String content, Class<T> valueType) throws CryptionFailException {
        ObjectMapper mapper = new ObjectMapper();
        List<T> results = new ArrayList<T>();
        try {
            @SuppressWarnings("unchecked")
            List<Object> list = mapper.readValue(content, List.class);
            for (Object o : list) {
                T c = mapper.convertValue(o, valueType);
                results.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CryptionFailException(ReturnCode.DECRYPT_FAIL);
        }
        return results;
    }

}
