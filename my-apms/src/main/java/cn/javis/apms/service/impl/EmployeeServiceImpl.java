package cn.javis.apms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.javis.apms.domain.property.Property;
import cn.javis.apms.repository.EmployeeRepository;
import cn.javis.apms.service.EmployeePropertyService;
import cn.javis.apms.service.EmployeeService;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeePropertyService eePropertyService;
    @Autowired
    private EmployeeRepository eeRepositoryService;

    @Override
    public Map<String, List<Property>> find(String[] ids) throws PropertyDefinitionNotFoundException {
        return eePropertyService.boxing(eeRepositoryService.find(ids));
    }

    @Override
    public Map<String, List<Property>> find(String[] ids, String[] property) throws PropertyDefinitionNotFoundException {
        return eePropertyService.boxing(eeRepositoryService.find(ids, property));
    }

    @Override
    public Map<String, List<Property>> find(String[] ids, String[] property, String date)
            throws PropertyDefinitionNotFoundException {
        return eePropertyService.boxing(eeRepositoryService.find(ids, property, date));
    }

    @Override
    public Map<String, List<Property>> find(String[] ids, String[] property, String dateDate, String endDate)
            throws PropertyDefinitionNotFoundException {
        return eePropertyService.boxing(eeRepositoryService.find(ids, property, dateDate, endDate));
    }

}
