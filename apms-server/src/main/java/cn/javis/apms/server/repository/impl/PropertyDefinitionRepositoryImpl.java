package cn.javis.apms.server.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.javis.apms.server.domain.PropertyDefinition;
import cn.javis.apms.server.repository.PropertyDefinitionRepository;
import cn.javis.apms.server.repository.base.HibernateBaseRepository;

@Repository
public class PropertyDefinitionRepositoryImpl extends HibernateBaseRepository<PropertyDefinition> implements
        PropertyDefinitionRepository {

    protected PropertyDefinitionRepositoryImpl() {
        super(PropertyDefinition.class);
    }

    @Override
    @Transactional
    public List<PropertyDefinition> fetchAll() {
        Criteria criteria = createCriteria();
        return criteria.list();
    }

}
