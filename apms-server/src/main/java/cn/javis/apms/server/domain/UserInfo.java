package cn.javis.apms.server.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import cn.javis.apms.common.Gender;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "myapms_userinfo")
@Getter
public class UserInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -469779554243563464L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    @JsonIgnore
    private Long id;

    @Column(name = "NAME", nullable = true)
    @JsonProperty
    private String name;

    @Column(name = "GENDER", nullable = true)
    @JsonProperty
    private Gender gender = Gender.Unknown;

    @Column(name = "GRADE")
    @JsonProperty
    private BigDecimal grade = BigDecimal.valueOf(5.0); // 用户评级

    @Column(name = "GRADE_TIMES")
    private int gradeTimes = 1; // 用户评级次数

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "myapms_userInfo_customer", joinColumns = { @JoinColumn(name = "USERINFO_ID", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID") })
    @JsonIgnore
    private List<Customer> customers;

    @JsonIgnore
    @OneToMany(mappedBy = "sender", cascade = { CascadeType.ALL })
    private List<Message> messages;

    public void update(UserInfo that) {
        this.name = that.name;
        this.gender = that.gender;
        this.gradeTimes++;
        this.grade = this.grade.multiply(BigDecimal.valueOf(gradeTimes - 1)).add(that.grade)
                .divide(BigDecimal.valueOf(gradeTimes), 2, RoundingMode.HALF_UP);
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addCustomers(List<Customer> customers) {
        this.customers.addAll(customers);
    }

}
