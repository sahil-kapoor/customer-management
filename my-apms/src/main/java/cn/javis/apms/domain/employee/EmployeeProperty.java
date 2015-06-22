package cn.javis.apms.domain.employee;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.Type;

import cn.javis.apms.domain.base.BaseProperty;

@Entity
@Table(name = "myapms_employee_property")
@NoArgsConstructor
@Getter
@Setter
public class EmployeeProperty extends BaseProperty {

    /**
     * 
     */
    private static final long serialVersionUID = 1213238507117112000L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id; // primary key in database

    @Column(name = "EMPLOYEE_ID")
    private String employeeId;

    @Type(type = "localDateUserType")
    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Temporal(TemporalType.DATE)
    @Type(type = "localDateUserType")
    @Column(name = "END_DATE")
    private LocalDate endDate;

    // @Column(name = "PROPERTY_NAME")
    // private String propertyName;
    //
    // @Column(name = "PROPERTY_VALUE")
    // private String propertyValue;

    @Column(name = "CONDITION_ID")
    private Long conditionId;

    @Column(name = "RESTRICTION_ID")
    private Long restrictionId;

    @Column(name = "CANDIDATE_ID")
    private Long candidateId;

}
