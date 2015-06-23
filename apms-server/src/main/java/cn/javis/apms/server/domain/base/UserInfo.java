package cn.javis.apms.server.domain.base;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserInfo implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 8327108815427781087L;
    private String userName; // the login user name
    private String userTerminal; // the ip addr or device name of login user
}
