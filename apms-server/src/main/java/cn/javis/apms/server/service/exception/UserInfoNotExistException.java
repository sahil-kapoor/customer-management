package cn.javis.apms.server.service.exception;

import cn.javis.apms.common.ApmsErrorCode;

public class UserInfoNotExistException extends Exception {

    private final ApmsErrorCode errCode;
    /**
     * 
     */
    private static final long serialVersionUID = -7608035956736128831L;

    public UserInfoNotExistException(ApmsErrorCode errCode) {
        super();
        this.errCode = errCode;
    }

    public ApmsErrorCode getErrCode() {
        return errCode;
    }

}
