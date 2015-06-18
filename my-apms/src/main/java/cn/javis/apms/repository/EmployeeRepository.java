package cn.javis.apms.repository;

import java.util.List;

import cn.javis.apms.domain.EmployeeProperty;
import cn.javis.apms.repository.base.GenericRepository;


public interface EmployeeRepository extends GenericRepository<EmployeeProperty, Long> {

    List<EmployeeProperty> find(String[] ids, String[] properties);

    List<EmployeeProperty> find(String[] ids, String[] properties, String date);

    List<EmployeeProperty> find(String[] ids);

    List<EmployeeProperty> find(String[] ids, String[] properties, String startDate, String endDate);
}
