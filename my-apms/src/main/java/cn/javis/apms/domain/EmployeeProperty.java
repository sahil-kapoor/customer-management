package cn.javis.apms.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.TypeDef;

import cn.javis.apms.repository.base.DateTimeUserType;

@Entity
@Table(name = "myapms_employee")
@NoArgsConstructor
@TypeDef(defaultForType = LocalDate.class, name = "DateUserType", typeClass = DateTimeUserType.class)
public class EmployeeProperty {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id; // primary key in database

    @Getter
    @Setter
    private String employeeId;

    @Getter
    @Setter
    private LocalDate startDate;

    @Getter
    @Setter
    private LocalDate endDate;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String value;

//    public Object getValue() {
//        return PropertyMapper.deserialize(this.value, this.dataType);
//    }
//
//    public void setValue(Object value) {
//        this.value = PropertyMapper.serialize(value, this.dataType);
//    }

}
