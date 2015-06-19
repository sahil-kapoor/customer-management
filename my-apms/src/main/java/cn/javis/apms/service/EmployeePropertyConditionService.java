package cn.javis.apms.service;

import java.util.List;

import cn.javis.apms.domain.PropertyCondition;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

public interface EmployeePropertyConditionService {

    void save(List<PropertyCondition> conditions);

    void update(List<PropertyCondition> conditions);

    List<PropertyCondition> find(Long conditionId);

    boolean checkCondition(Long employeeId, Long conditionId) throws PropertyDefinitionNotFoundException;

}
