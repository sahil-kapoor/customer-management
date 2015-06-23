package cn.javis.apms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.javis.apms.repository.EmployeePropertyRestrictionRepository;
import cn.javis.apms.repository.base.HibernateBaseRepository;
import cn.javis.apms.server.domain.PropertyRestriction;

@Repository
public class EmployeePropertyRestrictionRepositoryImpl extends HibernateBaseRepository<PropertyRestriction> implements EmployeePropertyRestrictionRepository {

    protected EmployeePropertyRestrictionRepositoryImpl() {
        super(PropertyRestriction.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public PropertyRestriction find(Long id) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("id", id));
        criteria.addOrder(Order.asc("id"));
        List<PropertyRestriction> list = criteria.list();
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    @Transactional
    public Long save(PropertyRestriction restriction) {
        return (Long) currentSession().save(restriction);
    }

    @Override
    @Transactional
    public PropertyRestriction update(PropertyRestriction restriction) {
        return (PropertyRestriction) currentSession().merge(restriction);
    }

}
