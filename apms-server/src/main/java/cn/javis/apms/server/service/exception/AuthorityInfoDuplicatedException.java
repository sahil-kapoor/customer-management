package cn.javis.apms.server.service.exception;

import lombok.Getter;
import cn.javis.apms.common.ReturnCode;

public class AuthorityInfoDuplicatedException extends Exception {
    @Getter
    private final ReturnCode code = ReturnCode.USER_DUPLICATED;
    /**
     * 
     */
    private static final long serialVersionUID = -4672350511521006927L;

}
