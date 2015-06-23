package cn.javis.apms.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import cn.javis.apms.repository.PropertyDefinitionRepository;
import cn.javis.apms.repository.base.HibernateBaseRepository;
import cn.javis.apms.server.domain.PropertyDefinition;

@Repository
public class PropertyDefinitionRepositoryImpl extends HibernateBaseRepository<PropertyDefinition> implements PropertyDefinitionRepository {

    protected PropertyDefinitionRepositoryImpl() {
        super(PropertyDefinition.class);
    }

    @Override
    public List<PropertyDefinition> fetchAll() {
        Criteria criteria = createCriteria();
        return criteria.list();
    }

}
