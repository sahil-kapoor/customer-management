package cn.javis.apms.server.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.javis.apms.server.domain.property.Property;
import cn.javis.apms.server.helper.EmployeePropertyWrapper;
import cn.javis.apms.server.repository.EmployeePropertyRepository;
import cn.javis.apms.server.service.EmployeePropertyService;
import cn.javis.apms.server.service.exception.PropertyDefinitionNotFoundException;

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
