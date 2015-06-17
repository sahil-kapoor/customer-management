package cn.javis.apms.repository.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.javis.apms.domain.EmployeeProperty;
import cn.javis.apms.repository.EmployeeRepositoryService;
import cn.javis.apms.repository.base.HibernateBaseRepository;


@Service
public class EmployeeRepositoryServiceImpl extends HibernateBaseRepository<EmployeeProperty, Long> implements EmployeeRepositoryService {

    protected EmployeeRepositoryServiceImpl() {
        super(EmployeeProperty.class);
    }

    @Override
    public List<EmployeeProperty> findByEmployeeId(String id) {
        return findByField("employeeId", id);
    }

}
