package cn.javis.apms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.javis.apms.domain.PropertyDefinition;
import cn.javis.apms.repository.PropertyDefinitionRepository;
import cn.javis.apms.service.PropertyDefinitionService;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

@Service
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
        throw new PropertyDefinitionNotFoundException("Property with name["
                + propertyName
                + "] not found!");
    }


}
