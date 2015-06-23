package cn.javis.apms.server.domain.base;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Type;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class BaseProperty implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -116416560276243887L;

    @Column(name = "PROPERTY_NAME")
    protected String propertyName;

    @Column(name = "PROPERTY_VALUE")
    protected String propertyValue;

    @Type(type = "localDateTimeUserType")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "GREATE_TIME", insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    protected LocalTime createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "localDateTimeUserType")
    @Column(name = "UPDATE_TIME", insertable = false, updatable = false)
    @Generated(GenerationTime.ALWAYS)
    protected LocalTime updateTime;

    @Type(type = "userInfoCompositeUserType")
    @Columns(columns = { @Column(name = "CREATER"), @Column(name = "CREATER_TERMINAL") })
    private UserInfo creater;

    @Type(type = "userInfoCompositeUserType")
    @Columns(columns = { @Column(name = "UPDATER"), @Column(name = "UPDATER_TERMINAL") })
    private UserInfo updater;

}
