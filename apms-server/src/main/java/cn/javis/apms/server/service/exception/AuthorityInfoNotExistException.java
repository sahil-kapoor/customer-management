package cn.javis.apms.server.service.exception;

import lombok.Getter;
import cn.javis.apms.common.ReturnCode;

public class AuthorityInfoNotExistException extends Exception {

    @Getter
    private final ReturnCode code = ReturnCode.USER_NOT_EXIST;
    /**
     * 
     */
    private static final long serialVersionUID = -7608035956736128831L;

}
