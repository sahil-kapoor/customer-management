package cn.javis.apms.server.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.javis.apms.server.domain.ErrorInfo;
import cn.javis.apms.service.exception.PropertyDefinitionNotFoundException;

@ControllerAdvice
public class EmployeeControllerAdvice {
    @ExceptionHandler(value = PropertyDefinitionNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorInfo> handlePropertyDefinitionNotFoundException(PropertyDefinitionNotFoundException e) {
        ErrorInfo err = new ErrorInfo(e.getMessage(), e.getStackTrace()[0], e.getClass());
        return new ResponseEntity<ErrorInfo>(err, HttpStatus.NOT_FOUND);
    }
}
