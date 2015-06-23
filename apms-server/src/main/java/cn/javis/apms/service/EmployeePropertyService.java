package cn.javis.apms.service;

import java.util.List;
import java.util.Map;

import cn.javis.apms.server.domain.property.Property;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;


public interface EmployeePropertyService {


    Map<String, List<Property>> find(String[] id) throws PropertyDefinitionNotFoundException;

    Map<String, List<Property>> find(String[] id, String[] property) throws PropertyDefinitionNotFoundException;

    Map<String, List<Property>> find(String[] ids, String[] property, String date)
            throws PropertyDefinitionNotFoundException;

    Map<String, List<Property>> find(String[] ids, String[] property, String dateDate, String endDate)
            throws PropertyDefinitionNotFoundException;


}
