package cn.javis.apms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.javis.apms.domain.EmployeeProperty;
import cn.javis.apms.domain.property.Property;
import cn.javis.apms.domain.property.PropertyValue;
import cn.javis.apms.helper.PropertyValueConverter;
import cn.javis.apms.service.EmployeePropertyService;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

@Service
public class EmployeePropertyServiceImpl implements EmployeePropertyService {

    @Override
    public Map<String, List<Property>> boxing(List<EmployeeProperty> employeePropertyList)
            throws PropertyDefinitionNotFoundException {
        Map<String, List<Property>> propertyMap = new HashMap<String, List<Property>>();
        if (employeePropertyList == null
                || employeePropertyList.isEmpty()) {
            return propertyMap;
        }
//        Collections.sort(employeePropertyList, new PropertyValueComparator());

        String employeeId = employeePropertyList.get(0).getEmployeeId();
        String propertyName = employeePropertyList.get(0).getName();
        List<Property> properties = new ArrayList<Property>();
        List<PropertyValue<?>> values = new ArrayList<PropertyValue<?>>();
        for (EmployeeProperty employeeProperty : employeePropertyList) {
            if (employeeProperty.getEmployeeId().equals(employeeId)) {
                if (employeeProperty.getName().equals(propertyName)) {
                    values.add(PropertyValueConverter.fromEmployeeProperty(employeeProperty));
                } else {
                    properties.add(new Property(propertyName, values));
                    propertyName = employeeProperty.getName();
                    values = new ArrayList<PropertyValue<?>>();
                    values.add(PropertyValueConverter.fromEmployeeProperty(employeeProperty));
                }
            } else {
                properties.add(new Property(propertyName, values));
                propertyMap.put(employeeId, properties);
                employeeId = employeeProperty.getEmployeeId();
                propertyName = employeeProperty.getName();
                properties = new ArrayList<Property>();
                values = new ArrayList<PropertyValue<?>>();
                values.add(PropertyValueConverter.fromEmployeeProperty(employeeProperty));
            }
        }
        properties.add(new Property(propertyName, values));
        propertyMap.put(employeeId, properties);
        employeeId = employeePropertyList.get(0).getEmployeeId();
        propertyName = employeePropertyList.get(0).getName();
        properties = new ArrayList<Property>();
        values = new ArrayList<PropertyValue<?>>();
        return propertyMap;
    }

}
