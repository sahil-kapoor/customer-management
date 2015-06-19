package cn.javis.apms.repository.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.javis.apms.domain.employee.EmployeeProperty;
import cn.javis.apms.repository.EmployeePropertyRepository;
import cn.javis.apms.repository.base.HibernateBaseRepository;

@Repository
public class EmployeePropertyRepositoryImpl extends HibernateBaseRepository<EmployeeProperty> implements EmployeePropertyRepository {

    protected EmployeePropertyRepositoryImpl() {
        super(EmployeeProperty.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<EmployeeProperty> find(String[] ids) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.in("employeeId", ids));
        criteria.addOrder(Order.asc("employeeId"));
        criteria.addOrder(Order.asc("propertyName"));
        criteria.addOrder(Order.desc("startDate"));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<EmployeeProperty> find(String[] ids, String date) {
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.in("employeeId", ids));
        criteria.add(Restrictions.le("startDate", localdate));
        criteria.add(Restrictions.ge("endDate", localdate));
        criteria.addOrder(Order.asc("employeeId"));
        criteria.addOrder(Order.asc("propertyName"));
        criteria.addOrder(Order.desc("startDate"));
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeProperty> find(String[] ids, String[] properties) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.in("employeeId", ids));
        criteria.add(Restrictions.in("propertyName", properties));
        criteria.addOrder(Order.asc("employeeId"));
        criteria.addOrder(Order.asc("propertyName"));
        criteria.addOrder(Order.desc("startDate"));
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeProperty> find(String[] ids, String[] properties, String date) {
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.in("employeeId", ids));
        criteria.add(Restrictions.in("propertyName", properties));
        criteria.add(Restrictions.le("startDate", localdate));
        criteria.add(Restrictions.ge("endDate", localdate));
        criteria.addOrder(Order.asc("employeeId"));
        criteria.addOrder(Order.asc("propertyName"));
        criteria.addOrder(Order.desc("startDate"));
        return criteria.list();
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeProperty> find(String[] ids, String[] properties, String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.in("employeeId", ids));
        criteria.add(Restrictions.in("propertyName", properties));
        criteria.add(Restrictions.not(Restrictions.ge("startDate", end)));
        criteria.add(Restrictions.not(Restrictions.le("endDate", start)));
        criteria.addOrder(Order.asc("employeeId"));
        criteria.addOrder(Order.asc("propertyName"));
        criteria.addOrder(Order.desc("startDate"));
        return criteria.list();
    }


}
