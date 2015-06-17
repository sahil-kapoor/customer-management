package cn.javis.apms.repository.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        return sessionFactory.getCurrentSession();
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

    @Transactional(readOnly = true)
    protected List<E> findByField(String fieldName, Object value) {
        return findByFieldWithQuery(entityClass, fieldName, value);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    private List<E> findByFieldWithQuery(Class<? extends E> clazz, String fieldName, Object value) {
        Criteria criteria = currentSession().createCriteria(clazz);
        criteria.setCacheable(false).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(Restrictions.eq(fieldName, value));
        return criteria.list();
    }
}
