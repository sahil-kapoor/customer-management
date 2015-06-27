package cn.javis.apms.common.helper.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import cn.javis.apms.common.ReturnCode;

@AllArgsConstructor
@Getter
public class StringWrongFormatException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -2422462017912658089L;

    private final ReturnCode code = ReturnCode.STRING_WRONG_FORMAT;
}
