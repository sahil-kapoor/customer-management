package cn.javis.apms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.javis.apms.domain.property.Property;
import cn.javis.apms.helper.EmployeePropertyWrapper;
import cn.javis.apms.repository.EmployeePropertyRepository;
import cn.javis.apms.service.EmployeePropertyService;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

@Service
public class EmployeePropertyServiceImpl implements EmployeePropertyService {

    @Autowired
    private EmployeePropertyRepository eeRepositoryService;

    @Override
    public Map<String, List<Property>> find(String[] ids) throws PropertyDefinitionNotFoundException {
        return EmployeePropertyWrapper.boxing(eeRepositoryService.find(ids));
    }


    @Override
    public Map<String, List<Property>> find(String[] ids, String[] property) throws PropertyDefinitionNotFoundException {
        return EmployeePropertyWrapper.boxing(eeRepositoryService.find(ids, property));
    }

    @Override
    public Map<String, List<Property>> find(String[] ids, String[] property, String date)
            throws PropertyDefinitionNotFoundException {
        return EmployeePropertyWrapper.boxing(eeRepositoryService.find(ids, property, date));
    }

    @Override
    public Map<String, List<Property>> find(String[] ids, String[] property, String dateDate, String endDate)
            throws PropertyDefinitionNotFoundException {
        return EmployeePropertyWrapper.boxing(eeRepositoryService.find(ids, property, dateDate, endDate));
    }

}
