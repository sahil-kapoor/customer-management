package cn.javis.apms.server.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.javis.apms.server.domain.AuthorityInfo;
import cn.javis.apms.server.repository.AuthorityInfoRepository;
import cn.javis.apms.server.repository.base.HibernateBaseRepository;

@Repository
public class AuthorityInfoRepositoryImpl extends HibernateBaseRepository<AuthorityInfo> implements
        AuthorityInfoRepository {

    protected AuthorityInfoRepositoryImpl() {
        super(AuthorityInfo.class);
    }

    @Override
    @Transactional
    public void save(AuthorityInfo authorityInfo) {
        currentSession().save(authorityInfo);
    }

    @Override
    @Transactional
    public void update(AuthorityInfo authorityInfo) {
        currentSession().merge(authorityInfo);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<AuthorityInfo> fetchAll() {
        Criteria criteria = createCriteria();
        return criteria.list();
    }

    @Override
    @Transactional
    public void delete(AuthorityInfo authorityInfo) {
        currentSession().delete(authorityInfo);
    }
}
