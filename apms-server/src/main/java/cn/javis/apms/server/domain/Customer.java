package cn.javis.apms.server.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import cn.javis.apms.common.Gender;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "myapms_customer")
@Getter
public class Customer implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 4429794471612174918L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    @JsonIgnore
    private Long id;

    @JsonProperty
    @Column(name = "NAME")
    private String name;

    @JsonProperty
    @Column(name = "GENDER")
    private Gender gender;

    @JsonIgnore
    @ManyToMany(mappedBy = "customers", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserInfo> users;

    // private Set<Message> messages;
}
