package cn.javis.apms.server.domain.property;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Property {
    private String propertyName;
    private List<PropertyValue<?>> valueList = new ArrayList<PropertyValue<?>>();

    public Object valueAt(LocalDate date) {
        for (PropertyValue<?> propertyValue : valueList) {
            if (propertyValue.within(date)) {
                return propertyValue.getValue();
            }
        }
        return null;
    }

    public List<Object> value(LocalDate startDate, LocalDate endDate) {
        List<Object> values = new ArrayList<Object>();
        for (PropertyValue<?> propertyValue : valueList) {
            if (propertyValue.within(startDate, endDate)) {
                values.add(propertyValue);
            }
        }
        return values;
    }

}
