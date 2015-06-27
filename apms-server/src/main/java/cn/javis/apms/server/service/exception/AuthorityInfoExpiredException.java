package cn.javis.apms.server.service.exception;

import lombok.Getter;
import cn.javis.apms.common.ReturnCode;

public class AuthorityInfoExpiredException extends Exception {
    @Getter
    private final ReturnCode code = ReturnCode.USER_WRONG_ACCESSKEY;
    /**
     * 
     */
    private static final long serialVersionUID = -4796414539142021639L;

}
