package cn.javis.apms.server.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.javis.apms.common.aes.exception.CryptionFailException;
import cn.javis.apms.common.helper.exception.StringWrongFormatException;
import cn.javis.apms.server.dto.ReturnInfo;
import cn.javis.apms.server.service.exception.AuthorityInfoDuplicatedException;
import cn.javis.apms.server.service.exception.AuthorityInfoExpiredException;
import cn.javis.apms.server.service.exception.AuthorityInfoNotExistException;
import cn.javis.apms.server.service.exception.AuthorityInfoWrongPasswordException;

@ControllerAdvice
public class UserInfoControllerAdvice {
    @ExceptionHandler(value = AuthorityInfoDuplicatedException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ReturnInfo> handleUserInfoDuplicatedException(AuthorityInfoDuplicatedException e) {
        ReturnInfo err = new ReturnInfo(e.getCode());
        return new ResponseEntity<ReturnInfo>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = AuthorityInfoNotExistException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ReturnInfo> handleUserInfoNotExistException(AuthorityInfoNotExistException e) {
        ReturnInfo err = new ReturnInfo(e.getCode());
        return new ResponseEntity<ReturnInfo>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = AuthorityInfoWrongPasswordException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ReturnInfo> handleUserInfoWrongPasswordException(AuthorityInfoWrongPasswordException e) {
        ReturnInfo err = new ReturnInfo(e.getCode());
        return new ResponseEntity<ReturnInfo>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = CryptionFailException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ReturnInfo> handleCryptionFailException(CryptionFailException e) {
        ReturnInfo err = new ReturnInfo(e.getCode());
        return new ResponseEntity<ReturnInfo>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = StringWrongFormatException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ReturnInfo> handleStringWrongFormatException(StringWrongFormatException e) {
        ReturnInfo err = new ReturnInfo(e.getCode());
        return new ResponseEntity<ReturnInfo>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(value = AuthorityInfoExpiredException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ReturnInfo> handleAuthorityInfoExpiredException(AuthorityInfoExpiredException e) {
        ReturnInfo err = new ReturnInfo(e.getCode());
        return new ResponseEntity<ReturnInfo>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
