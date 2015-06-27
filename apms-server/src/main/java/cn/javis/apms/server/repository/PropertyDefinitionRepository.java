package cn.javis.apms.server.repository;
import java.util.List;

import cn.javis.apms.server.domain.PropertyDefinition;

public interface PropertyDefinitionRepository{
    List<PropertyDefinition> fetchAll();
}
