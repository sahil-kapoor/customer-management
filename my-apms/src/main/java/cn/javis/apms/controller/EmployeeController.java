package cn.javis.apms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.javis.apms.domain.property.Property;
import cn.javis.apms.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee", method = RequestMethod.GET)
public class EmployeeController {
    @Autowired
    EmployeeService eeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Property find(@PathVariable String id) {
        return eeService.find(id);
    }

}
