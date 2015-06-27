package cn.javis.apms.server.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.javis.apms.common.ReturnCode;
import cn.javis.apms.server.dto.ReturnInfo;
import cn.javis.apms.server.service.exception.PropertyDefinitionNotFoundException;

@ControllerAdvice
public class EmployeeControllerAdvice {
    @ExceptionHandler(value = PropertyDefinitionNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<ReturnInfo> handlePropertyDefinitionNotFoundException(PropertyDefinitionNotFoundException e) {
        ReturnInfo err = new ReturnInfo(ReturnCode.PROPERTY_NOT_FOUND);
        return new ResponseEntity<ReturnInfo>(err, HttpStatus.NOT_FOUND);
    }
}
