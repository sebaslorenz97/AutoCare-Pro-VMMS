package com.dulsystems.autocare_pro_vmms.domain.exception;

import com.dulsystems.autocare_pro_vmms.domain.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorDto> businessExceptionHandler(BusinessException bex){
        ErrorDto errorBean = ErrorDto.builder().code(bex.getCode()).message(bex.getMessage()).build();
        return new ResponseEntity<>(errorBean, bex.getStatus());
    }
}
