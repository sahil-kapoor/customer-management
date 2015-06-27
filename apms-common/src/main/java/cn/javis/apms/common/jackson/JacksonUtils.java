package cn.javis.apms.common.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JacksonUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String object2String(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static <T> T string2Object(String content, Class<T> valueType) throws IOException {
        return mapper.readValue(content, valueType);
    }
}
