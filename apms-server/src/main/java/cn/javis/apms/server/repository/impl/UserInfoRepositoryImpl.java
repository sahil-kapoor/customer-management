package cn.javis.apms.server.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.javis.apms.server.domain.crypt.UserInfo;
import cn.javis.apms.server.repository.UserInfoRepository;
import cn.javis.apms.server.repository.base.HibernateBaseRepository;

@Repository
public class UserInfoRepositoryImpl extends HibernateBaseRepository<UserInfo> implements UserInfoRepository {

    protected UserInfoRepositoryImpl() {
        super(UserInfo.class);
    }

    @Override
    @Transactional
    public void save(UserInfo userInfo) {
        currentSession().save(userInfo);
    }

    @Override
    @Transactional
    public void update(UserInfo userInfo) {
        currentSession().merge(userInfo);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public List<UserInfo> fetchAll() {
        Criteria criteria = createCriteria();
        return criteria.list();
    }

    @Override
    @Transactional
    public void delete(UserInfo userInfo) {
        currentSession().delete(userInfo);

    }
}
