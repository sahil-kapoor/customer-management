package cn.javis.apms.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.javis.apms.domain.EmployeeProperty;
import cn.javis.apms.domain.property.Property;
import cn.javis.apms.domain.property.PropertyValue;
import cn.javis.apms.service.EmployeePropertyService;

@Service
public class EmployeePropertyServiceImpl implements EmployeePropertyService {

    @Override
    public Property boxing(List<EmployeeProperty> employeePropertyList) {
        if (employeePropertyList == null
                || employeePropertyList.isEmpty()) {
            return null;
        }
        Collections.sort(employeePropertyList, new PropertyValueComparator());
        String propertyName = employeePropertyList.get(0).getName();
        List<PropertyValue> values = new ArrayList<PropertyValue>();
        for (EmployeeProperty employeeProperty : employeePropertyList) {
            PropertyValue propertyValue = new PropertyValue(
                    employeeProperty.getId(), employeeProperty.getStartDate(), employeeProperty.getEndDate(),
                    employeeProperty.getValue());
            values.add(propertyValue);
        }
        return new Property(propertyName, values);
    }

    private class PropertyValueComparator implements Comparator<EmployeeProperty> {
        @Override
        public int compare(EmployeeProperty o1, EmployeeProperty o2) {
            return o1.getStartDate().compareTo(o2.getStartDate());
        }
    }

}
