package cn.javis.apms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.javis.apms.domain.PropertyCondition;
import cn.javis.apms.repository.EmployeePropertyConditionRepository;
import cn.javis.apms.repository.base.HibernateBaseRepository;

@Repository
public class EmployeePropertyConditionRepositoryImpl extends HibernateBaseRepository<PropertyCondition> implements EmployeePropertyConditionRepository {

    protected EmployeePropertyConditionRepositoryImpl() {
        super(PropertyCondition.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List<PropertyCondition> find(Long conditionId) {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq("conditionId", conditionId));
        criteria.addOrder(Order.asc("index"));
        return criteria.list();
    }

    @Override
    @Transactional
    public void save(List<PropertyCondition> conditionsList) {
        for (PropertyCondition condition : conditionsList) {
            currentSession().save(condition);
        }
    }

    @Override
    @Transactional
    public void update(List<PropertyCondition> conditionsList) {
        if (conditionsList != null
                && !conditionsList.isEmpty()) {
            PropertyCondition first = conditionsList.get(0);
            delete(first.getConditionId());
        }
        for (PropertyCondition condition : conditionsList) {
            currentSession().merge(condition);
        }
    }

    @Override
    public void delete(Long conditionId) {
        String hql = "DELETE FROM EmployeePropertyCondition WHERE conditionId = :conditionId";
        Query query = currentSession().createQuery(hql);
        query.setLong("conditionId", conditionId);
        query.executeUpdate();
    }

}
