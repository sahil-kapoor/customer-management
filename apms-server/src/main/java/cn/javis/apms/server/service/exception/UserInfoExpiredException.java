package cn.javis.apms.server.service.exception;

import cn.javis.apms.common.ApmsErrorCode;

public class UserInfoExpiredException extends Exception {

    private final ApmsErrorCode errCode;
    /**
     * 
     */
    private static final long serialVersionUID = -4796414539142021639L;

    public UserInfoExpiredException(ApmsErrorCode errCode) {
        super();
        this.errCode = errCode;
    }

    public ApmsErrorCode getErrCode() {
        return errCode;
    }

}