package cn.javis.apms.server.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "myapms_property_restriction")
@Data 
public class PropertyRestriction implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 6228320666485241754L;

    @Id
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
