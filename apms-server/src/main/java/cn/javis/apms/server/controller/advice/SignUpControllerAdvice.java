package cn.javis.apms.server.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.javis.apms.common.ApmsErrorCode;
import cn.javis.apms.server.dto.ErrorInfo;
import cn.javis.apms.server.service.exception.UserInfoDuplicatedException;

@ControllerAdvice
public class SignUpControllerAdvice {
    @ExceptionHandler(value = UserInfoDuplicatedException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorInfo> handleUserInfoDuplicatedException(UserInfoDuplicatedException e) {
        ErrorInfo err = new ErrorInfo(ApmsErrorCode.USER_DUPLICATED);
        return new ResponseEntity<ErrorInfo>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
