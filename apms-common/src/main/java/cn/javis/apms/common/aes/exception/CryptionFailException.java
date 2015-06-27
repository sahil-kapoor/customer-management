package cn.javis.apms.common.aes.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import cn.javis.apms.common.ReturnCode;

@AllArgsConstructor
@Getter
public class CryptionFailException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 6188078156398464762L;

    private ReturnCode code;

}
