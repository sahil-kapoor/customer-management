package cn.javis.apms.server.service.exception;

import lombok.Getter;
import cn.javis.apms.common.ReturnCode;

public class AuthorityInfoWrongPasswordException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = -8351173784616633551L;

    @Getter
    private final ReturnCode code = ReturnCode.USER_WRONG_PASSWORD;

}
