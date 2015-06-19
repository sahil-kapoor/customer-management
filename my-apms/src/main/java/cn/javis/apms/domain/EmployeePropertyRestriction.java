package cn.javis.apms.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "myapms_employee_property_restriction")
@Data 
public class EmployeePropertyRestriction {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id; // primary key in database

    @Column(name = "NULLABLE")
    private Boolean nullable = null;
    @Column(name = "MIN_VALUE")
    private BigDecimal minValue = null;
    @Column(name = "MAX_VALUE")
    private BigDecimal maxValue = null;
    @Column(name = "REGEX")
    private String regex = null;
    @Column(name = "LENGTH")
    private Integer length = null;
}
