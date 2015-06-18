package cn.javis.apms.service;

import cn.javis.apms.domain.PropertyDefinition;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

public interface PropertyDefinitionService {
    PropertyDefinition getPropertyDefinition(String propertyName) throws PropertyDefinitionNotFoundException;
}
