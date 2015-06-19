package cn.javis.apms.domain.employee;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.annotations.TypeDef;

import cn.javis.apms.domain.base.BaseProperty;
import cn.javis.apms.repository.base.DateTimeUserType;

@Entity
@Table(name = "myapms_employee_property")
@Data
@TypeDef(defaultForType = LocalDate.class, name = "LocalDateUserType", typeClass = DateTimeUserType.class)
public class EmployeeProperty extends BaseProperty implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7519035295056826448L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id; // primary key in database

    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

//    @Column(name = "PROPERTY_NAME")
//    private String propertyName;
//
//    @Column(name = "PROPERTY_VALUE")
//    private String propertyValue;

    @Column(name = "CONDITION_ID")
    private Long conditionId;

    @Column(name = "RESTRICTION_ID")
    private Long restrictionId;

    @Column(name = "CANDIDATE_ID")
    private Long candidateId;

}
