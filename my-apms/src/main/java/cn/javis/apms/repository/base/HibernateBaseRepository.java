package cn.javis.apms.repository.base;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class HibernateBaseRepository<E, P extends Serializable> implements GenericRepository<E, P> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<E> entityClass;

    protected HibernateBaseRepository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public E find(P id) {
        return (E) currentSession().get(entityClass, id);
    }

    @Override
    @Transactional
    public void create(E entity) {
        currentSession().saveOrUpdate(entity);

    }

    @Override
    @Transactional
    public void update(E entity) {
        currentSession().merge(entity);

    }

    @Override
    @Transactional
    public void delete(E entity) {
        currentSession().delete(entity);
    }

    public Criteria createCriteria() {
        Criteria criteria = currentSession().createCriteria(entityClass);
        criteria.setCacheable(false).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria;
    }

}
