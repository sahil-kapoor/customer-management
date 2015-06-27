package cn.javis.apms.server.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "myapms_userinfo")
public class UserInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -469779554243563464L;

    public static enum Sex {
        Male, Female, Unknown
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    @JsonProperty
    private Long id;

    @Column(name = "NAME", nullable = true)
    @JsonProperty
    private String name;

    @Column(name = "SEX", nullable = true)
    @JsonProperty
    private Sex sex;

    @Column(name = "GRADE")
    @JsonProperty
    private BigDecimal grade = BigDecimal.valueOf(5.0); // 用户评级

    @Column(name = "GRADE_TIMES")
    private int gradeTimes = 1; // 用户评级次数

    public void update(UserInfo that) {
        this.name = that.name;
        this.sex = that.sex;
        this.gradeTimes++;
        this.grade = this.grade.multiply(BigDecimal.valueOf(gradeTimes - 1)).add(that.grade)
                .divide(BigDecimal.valueOf(gradeTimes), 2, RoundingMode.HALF_UP);

    }

}
