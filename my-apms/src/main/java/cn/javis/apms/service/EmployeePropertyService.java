package cn.javis.apms.service;

import java.util.List;
import java.util.Map;

import cn.javis.apms.domain.EmployeeProperty;
import cn.javis.apms.domain.property.Property;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

public interface EmployeePropertyService {
    Map<String, List<Property>> boxing(List<EmployeeProperty> EmployeePropertyList)
            throws PropertyDefinitionNotFoundException;
}
