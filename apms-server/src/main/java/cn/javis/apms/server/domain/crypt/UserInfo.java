package cn.javis.apms.server.domain.crypt;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apms_userinfo")
public class UserInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1228684508474703974L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "USERNAME_MD5")
    private String usernameMd5;

    @Column(name = "PASSWORD_MD5")
    private String passwordMd5;

    @Column(name = "ACCESS_KEY")
    private String accessKey;
}
