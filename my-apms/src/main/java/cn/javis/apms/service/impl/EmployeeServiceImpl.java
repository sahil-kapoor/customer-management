package cn.javis.apms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.javis.apms.domain.property.Property;
import cn.javis.apms.repository.EmployeeRepositoryService;
import cn.javis.apms.service.EmployeePropertyService;
import cn.javis.apms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeePropertyService eePropertyService;
    @Autowired
    private EmployeeRepositoryService eeRepositoryService;

    @Override
    @Transactional(readOnly = true)
    public Property find(String id) {
        return eePropertyService.boxing(eeRepositoryService.findByEmployeeId(id));
    }

}
