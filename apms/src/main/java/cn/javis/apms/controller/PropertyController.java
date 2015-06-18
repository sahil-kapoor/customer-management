package cn.javis.apms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.javis.apms.domain.Property;

@RestController
@RequestMapping(value = "/")
public class PropertyController {

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public List<Property> getLatestPropertyById(@PathVariable String id) {
        List<Property> properties = new ArrayList<Property>();
        return properties;
    }
}
