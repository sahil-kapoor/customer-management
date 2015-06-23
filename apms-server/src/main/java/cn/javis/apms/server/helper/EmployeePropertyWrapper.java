package cn.javis.apms.server.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.javis.apms.server.domain.employee.EmployeeProperty;
import cn.javis.apms.server.domain.property.Property;
import cn.javis.apms.server.domain.property.PropertyValue;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;


public final class EmployeePropertyWrapper {

    public static Map<String, List<Property>> boxing(List<EmployeeProperty> employeePropertyList)
            throws PropertyDefinitionNotFoundException {
        Map<String, List<Property>> propertyMap = new HashMap<String, List<Property>>();
        if (employeePropertyList == null
                || employeePropertyList.isEmpty()) {
            return propertyMap;
        }
//        Collections.sort(employeePropertyList, new PropertyValueComparator());

        String employeeId = employeePropertyList.get(0).getEmployeeId();
        String propertyName = employeePropertyList.get(0).getPropertyName();
        List<Property> properties = new ArrayList<Property>();
        List<PropertyValue<?>> values = new ArrayList<PropertyValue<?>>();
        for (EmployeeProperty employeeProperty : employeePropertyList) {
            if (employeeProperty.getEmployeeId().equals(employeeId)) {
                if (employeeProperty.getPropertyName().equals(propertyName)) {
                    values.add(PropertyValueConverter.fromEmployeeProperty(employeeProperty));
                } else {
                    properties.add(new Property(propertyName, values));
                    propertyName = employeeProperty.getPropertyName();
                    values = new ArrayList<PropertyValue<?>>();
                    values.add(PropertyValueConverter.fromEmployeeProperty(employeeProperty));
                }
            } else {
                properties.add(new Property(propertyName, values));
                propertyMap.put(employeeId, properties);
                employeeId = employeeProperty.getEmployeeId();
                propertyName = employeeProperty.getPropertyName();
                properties = new ArrayList<Property>();
                values = new ArrayList<PropertyValue<?>>();
                values.add(PropertyValueConverter.fromEmployeeProperty(employeeProperty));
            }
        }
        properties.add(new Property(propertyName, values));
        propertyMap.put(employeeId, properties);
        employeeId = employeePropertyList.get(0).getEmployeeId();
        propertyName = employeePropertyList.get(0).getPropertyName();
        properties = new ArrayList<Property>();
        values = new ArrayList<PropertyValue<?>>();
        return propertyMap;
    }

}
