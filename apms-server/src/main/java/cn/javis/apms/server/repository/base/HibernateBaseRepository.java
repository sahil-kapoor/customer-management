package cn.javis.apms.server.repository.base;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class HibernateBaseRepository<E> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<E> entityClass;

    protected HibernateBaseRepository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Criteria createCriteria() {
        Criteria criteria = currentSession().createCriteria(entityClass);
        criteria.setCacheable(false).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria;
    }

}
