package cn.javis.apms.service;

import java.util.List;

import cn.javis.apms.domain.EmployeeProperty;
import cn.javis.apms.domain.property.Property;


public interface EmployeePropertyService {
    Property boxing(List<EmployeeProperty> EmployeePropertyList);
}
