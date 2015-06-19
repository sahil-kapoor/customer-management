package cn.javis.apms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import cn.javis.apms.domain.condition.Condition;
import cn.javis.apms.helper.PropertyDefinitionEvaluator;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

@Entity
@Table(name = "myapms_property_condition")
@Data
public class PropertyCondition implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 5284295903129551643L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "FACTOR_ID")
    private Long factorId; // primary key in database

    @Column(name = "PROPERTY_NAME")
    private String propertyName;

    @Column(name = "CONDITION_COMPARATOR")
    private Condition condition; // comparator with propertyName and values

    @Column(name = "PROPERTY_VALUES")
    private String propertyValues;

    public boolean isSatisfied(String strValue) {
        try {
            return PropertyDefinitionEvaluator.eval(strValue, this);
        } catch (PropertyDefinitionNotFoundException e) {
            return false;
        }
    }
}
