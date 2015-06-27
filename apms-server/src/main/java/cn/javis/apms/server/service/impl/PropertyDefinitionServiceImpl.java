package cn.javis.apms.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.javis.apms.server.domain.PropertyDefinition;
import cn.javis.apms.server.repository.PropertyDefinitionRepository;
import cn.javis.apms.server.service.PropertyDefinitionService;
import cn.javis.apms.server.service.exception.PropertyDefinitionNotFoundException;

@Service
@Transactional
public class PropertyDefinitionServiceImpl implements PropertyDefinitionService {

    PropertyDefinitionRepository propertyDefinitionRepo;

    private Map<String, PropertyDefinition> propertyDefinitionMapByName = new HashMap<String, PropertyDefinition>();

    @Autowired
    public PropertyDefinitionServiceImpl(PropertyDefinitionRepository propertyDefinitionRepo) {
        this.propertyDefinitionRepo = propertyDefinitionRepo;
        List<PropertyDefinition> propertyDefinitionList = propertyDefinitionRepo.fetchAll();
        for (PropertyDefinition pd : propertyDefinitionList) {
            propertyDefinitionMapByName.put(pd.getPropertyName(), pd);
        }
    }

    @Override
    public PropertyDefinition getPropertyDefinition(String propertyName) throws PropertyDefinitionNotFoundException {
        PropertyDefinition pd = propertyDefinitionMapByName.get(propertyName);
        if (pd != null) {
            return pd;
        }
        throw new PropertyDefinitionNotFoundException("Property with name[" + propertyName + "] not found!");
    }

}
