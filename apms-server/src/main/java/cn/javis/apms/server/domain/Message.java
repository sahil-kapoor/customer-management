package cn.javis.apms.server.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "myapms_message")
@Data
public class Message implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @ManyToOne
    private UserInfo sender;

    // private Set<Customer> receivers;

    @Column(name = "CONTENT")
    private String content;

}
