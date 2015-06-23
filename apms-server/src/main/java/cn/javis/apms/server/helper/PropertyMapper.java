package cn.javis.apms.server.helper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import cn.javis.apms.server.domain.DataType;

public class PropertyMapper {
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

    public static Object deserialize(String strValue, DataType dataType) {
        if (strValue != null) {
            try {
                switch (dataType) {
                    case STRING:
                        return strValue;
                    case BOOLEAN:
                        return Boolean.valueOf(strValue);
                    case DATE:
                        return new SimpleDateFormat("yyyy/MM/dd").parse(strValue);

                    case DECIMAL:
                        return new BigDecimal(strValue);
                    case INTEGER:
                        return Integer.valueOf(strValue);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String serialize(Object value, DataType dataType) {
        if (value != null) {
            switch(dataType) {
                case STRING:
                    return (String) value;
                case DATE:
                    return new SimpleDateFormat().format(value);
                case BOOLEAN:
                case DECIMAL:
                case INTEGER:
                    return String.valueOf(value);
            }
        }
        return null;
    }
}
