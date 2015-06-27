package cn.javis.apms.server.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "myapms_authority_info")
@Data
public class AuthorityInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1228684508474703974L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "USERNAME_MD5", nullable = false)
    private String usernameMd5;

    @Column(name = "PASSWORD_MD5", nullable = false)
    private String passwordMd5;

    @Column(name = "ACCESS_KEY", nullable = false)
    private String accessKey;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "USER_INFO")
    private UserInfo userInfo = new UserInfo();

}
