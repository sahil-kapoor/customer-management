package cn.javis.apms.server.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.javis.apms.common.DataType;
import lombok.Data;

@Entity
@Table(name = "myapms_property_definition")
@Data
public class PropertyDefinition {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "PROPERTY_NAME")
    private String propertyName;

    @Column(name = "DATA_TYPE")
    private DataType dateType;

    @Column(name = "DEFAULT_VALUE")
    private String defaultValue;

    @Column(name = "DESCRIPTION")
    private String description;

}
