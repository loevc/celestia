package com.loevc.celestia.common.exception;

import cn.hutool.log.AbstractLog;
import com.loevc.celestia.common.util.ApiResponse;
import com.loevc.celestia.common.util.ResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author caijiliu
 * @Email L13831467435@163.com
 * @Date 2023/10/10 19:05
 * @Description
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//
//        });
        ObjectError objectError = ex.getBindingResult().getAllErrors().get(0);
        String defaultMessage = objectError.getDefaultMessage();
        ApiResponse apiResponse = ApiResponse.restResult(ResponseCode.Fail.getCode(), defaultMessage, null);
        return ResponseEntity.status(HttpStatus.OK).body((Map<String, String>) apiResponse);
    }
}
