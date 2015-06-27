package cn.javis.apms.server.repository;

import java.util.List;

import cn.javis.apms.server.domain.employee.EmployeeProperty;

public interface EmployeePropertyRepository {

    List<EmployeeProperty> find(String[] ids, String[] properties);

    List<EmployeeProperty> find(String[] ids, String[] properties, String date);

    List<EmployeeProperty> find(String[] ids);

    List<EmployeeProperty> find(String[] ids, String[] properties, String startDate, String endDate);

    List<EmployeeProperty> find(String[] ids, String date);
}
