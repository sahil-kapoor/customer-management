package cn.javis.apms.server.repository;

import java.util.List;

import cn.javis.apms.server.domain.PropertyCondition;

public interface EmployeePropertyConditionRepository {

    List<PropertyCondition> find(Long conditionId);

    void delete(Long conditionId);

    void save(List<PropertyCondition> conditionsList);

    void update(List<PropertyCondition> conditionsList);

}
