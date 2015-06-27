package cn.javis.apms.server.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.javis.apms.common.ApmsErrorCode;
import cn.javis.apms.server.dto.ErrorInfo;
import cn.javis.apms.server.service.exception.PropertyDefinitionNotFoundException;

@ControllerAdvice
public class EmployeeControllerAdvice {
    @ExceptionHandler(value = PropertyDefinitionNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorInfo> handlePropertyDefinitionNotFoundException(PropertyDefinitionNotFoundException e) {
        ErrorInfo err = new ErrorInfo(ApmsErrorCode.PROPERTY_NOT_FOUND);
        return new ResponseEntity<ErrorInfo>(err, HttpStatus.NOT_FOUND);
    }
}
