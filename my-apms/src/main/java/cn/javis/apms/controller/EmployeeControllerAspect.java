package cn.javis.apms.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.javis.apms.service.PropertyDefinitionService;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

@Aspect
@Component
public class EmployeeControllerAspect {
    @Autowired
    PropertyDefinitionService propertyDefinitionService;

//    @Pointcut("execution(** cn.javis.apms.controller.EmployeeController.*(String, String) && args(ids, property)")
//    public void find(String id, String property) {
//    };
//
//    @Pointcut("execution(** cn.javis.apms.controller.EmployeeController.*(String, String, String) && args(ids, property,date)")
//    public void find(String id, String property, String date) {
//    };

    @Pointcut("execution( * cn.javis.apms.controller.EmployeeController.findGivenPropertyAtGivenDate(String, String, String, String)) && args(ids, property,startDate, endDate)")
    public void find(String ids, String property, String startDate, String endDate) {
    };

    //

    @Before("find(ids, property,startDate, endDate)")
    public void propertyValidation(String ids, String property, String startDate, String endDate)
            throws PropertyDefinitionNotFoundException {
        String[] properties = property.split(",");
        for (String pro : properties) {
            propertyDefinitionService.getPropertyDefinition(pro);
        }
    }
}
