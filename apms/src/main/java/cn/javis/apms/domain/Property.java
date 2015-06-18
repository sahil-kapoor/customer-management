package cn.javis.apms.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class Property {
    // name of property
    @Getter
    private String propertyName;
    
    // history value list
    @Getter
    private List<PropertyValue> values = new ArrayList<PropertyValue>();

    public Property(String name) {
        this.propertyName = name;
    }
}
