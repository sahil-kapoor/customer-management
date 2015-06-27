package cn.javis.apms.server.service.exception;

import cn.javis.apms.common.ApmsErrorCode;

public class UserInfoDuplicatedException extends Exception {

    private final ApmsErrorCode errCode;
    /**
     * 
     */
    private static final long serialVersionUID = -4672350511521006927L;

    public UserInfoDuplicatedException(ApmsErrorCode errCode) {
        super();
        this.errCode = errCode;
    }

    public ApmsErrorCode getErrCode() {
        return errCode;
    }
}
