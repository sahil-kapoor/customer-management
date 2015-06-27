package cn.javis.apms.server.service;

import cn.javis.apms.server.domain.PropertyDefinition;
import cn.javis.apms.server.service.exception.PropertyDefinitionNotFoundException;

public interface PropertyDefinitionService {
    PropertyDefinition getPropertyDefinition(String propertyName) throws PropertyDefinitionNotFoundException;
}
