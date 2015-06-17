package cn.javis.apms.repository;

import java.util.List;

import cn.javis.apms.domain.EmployeeProperty;
import cn.javis.apms.repository.base.GenericRepository;


public interface EmployeeRepositoryService extends GenericRepository<EmployeeProperty, Long> {
    List<EmployeeProperty> findByEmployeeId(String id);
}
