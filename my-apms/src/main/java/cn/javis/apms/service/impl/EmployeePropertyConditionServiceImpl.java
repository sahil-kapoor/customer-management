package cn.javis.apms.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.javis.apms.domain.PropertyCondition;
import cn.javis.apms.domain.employee.EmployeeProperty;
import cn.javis.apms.repository.EmployeePropertyConditionRepository;
import cn.javis.apms.repository.EmployeePropertyRepository;
import cn.javis.apms.service.EmployeePropertyConditionService;
import cn.javis.apms.service.PropertyDefinitionService;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

@Service
public class EmployeePropertyConditionServiceImpl implements EmployeePropertyConditionService {
    @Autowired
    private EmployeePropertyConditionRepository eePropertyConditionRepo;

    @Autowired
    private EmployeePropertyRepository eeRepositoryService;

    @Autowired
    private PropertyDefinitionService propertyDefinitionService;

    private Map<Long, List<PropertyCondition>> conditionMapByConditionId;

    @Override
    public boolean checkCondition(Long employeeId, Long conditionId) throws PropertyDefinitionNotFoundException {
        List<PropertyCondition> conditionList = find(conditionId);
        List<EmployeeProperty> employeeProperties = eeRepositoryService.find(
                new String[] { String.valueOf(employeeId) },
                LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        Map<String, String> propertyNameValueMap = new HashMap<String, String>();
        for (EmployeeProperty eeProperty : employeeProperties) {
            propertyNameValueMap.put(eeProperty.getPropertyName(), eeProperty.getPropertyValue());
        }
        boolean checkResult = true;

        for (PropertyCondition condition : conditionList) {
            String propertyValue = propertyNameValueMap.get(condition.getPropertyName());
//            switch (condition.getOperator()) {
//                case AND:
//                    checkResult = checkResult
//                    && isValueSatisfy(propertyValue, condition);
//                case OR:
//                    checkResult = checkResult
//                    && isValueSatisfy(propertyValue, condition);
//            }
        }

        return checkResult;
    }



    @Override
    public List<PropertyCondition> find(Long conditionId) {
        if (conditionMapByConditionId.containsKey(conditionId)) {
            return conditionMapByConditionId.get(conditionId);
        } else {
            List<PropertyCondition> condition = eePropertyConditionRepo.find(conditionId);
            conditionMapByConditionId.put(conditionId, condition);
            return condition;
        }
    }

    @Override
    public void update(List<PropertyCondition> conditions) {
        if (conditions != null
                && !conditions.isEmpty()) {
            eePropertyConditionRepo.update(conditions);
            PropertyCondition first = conditions.get(0);
            conditionMapByConditionId.put(first.getConditionId(), conditions);
        }
    }

    @Override
    public void save(List<PropertyCondition> conditions) {
        if (conditions != null
                && !conditions.isEmpty()) {
            eePropertyConditionRepo.save(conditions);
            PropertyCondition first = conditions.get(0);
            conditionMapByConditionId.put(first.getConditionId(), conditions);
        }
    }

}
