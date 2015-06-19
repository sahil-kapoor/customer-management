package cn.javis.apms.domain.base;

import javax.persistence.Column;

import lombok.Data;

@Data
public abstract class BaseProperty {
    @Column(name = "PROPERTY_NAME")
    protected String propertyName;
    @Column(name = "PROPERTY_VALUE")
    protected String propertyValue;
}
