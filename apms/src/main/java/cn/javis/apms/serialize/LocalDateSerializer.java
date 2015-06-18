package cn.javis.apms.serialize;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import cn.javis.apms.common.ApmsConst;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate arg0, JsonGenerator arg1,
            SerializerProvider arg2) throws IOException,
            JsonProcessingException {
        if (arg0 != null) {
            arg1.writeString(arg0.format(DateTimeFormatter
                    .ofPattern(ApmsConst.DATE_FORMAT)));
        } else {
            arg1.writeString("");
        }

    }

}
