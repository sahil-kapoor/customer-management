package cn.javis.apms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "myapms_employee_property_condition")
@Data
public class EmployeePropertyCondition {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id; // primary key in database
    private int index;
    private String propertyName;
    private Condition condition; // comparator with propertyName and values
    private String values;
    private Operator operator; // operator with following conditions

    public static enum Condition {
        IN, GT, EQ, LT
    }

    public static enum Operator {
        OR, AND
    }
}
