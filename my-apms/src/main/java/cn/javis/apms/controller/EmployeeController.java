package cn.javis.apms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.javis.apms.domain.property.Property;
import cn.javis.apms.service.EmployeeService;
import cn.javis.apms.service.PropertyDefinitionService;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

@RestController
@RequestMapping(value = "/employee", method = RequestMethod.GET)
public class EmployeeController {
    @Autowired
    EmployeeService eeService;
    @Autowired
    PropertyDefinitionService propertyDefinitionService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Map<String, List<Property>> findAllProperty(@PathVariable String id)
            throws PropertyDefinitionNotFoundException {
        return eeService.find(id.split(","));
    }

    @RequestMapping(value = "/id/{id}/property/{property}", method = RequestMethod.GET)
    public Map<String, List<Property>> findGivenProperty(@PathVariable String id, @PathVariable String property)
            throws PropertyDefinitionNotFoundException {
        return eeService.find(id.split(","), property.split(","));
    }

    @RequestMapping(value = "/id/{id}/property/{property}/at/{date}", method = RequestMethod.GET)
    public Map<String, List<Property>> findGivenPropertyAtGivenDate(@PathVariable String id,
            @PathVariable String property, @PathVariable String date)
                    throws PropertyDefinitionNotFoundException {
        return eeService.find(id.split(","), property.split(","), date);
    }

    @RequestMapping(value = "/id/{id}/property/{property}/startdate/{startdate}/enddate/{enddate}", method = RequestMethod.GET)
    public Map<String, List<Property>> findGivenPropertyAtGivenDate(@PathVariable String id,
            @PathVariable String property, @PathVariable String startdate, @PathVariable String enddate)
                    throws PropertyDefinitionNotFoundException {
        throw new PropertyDefinitionNotFoundException("test");

//        return eeService.find(id.split(","), property.split(","), startdate, enddate);
    }



}
