package cn.javis.apms.repository;
import java.util.List;

import cn.javis.apms.domain.PropertyDefinition;

public interface PropertyDefinitionRepository{
    List<PropertyDefinition> fetchAll();
}
