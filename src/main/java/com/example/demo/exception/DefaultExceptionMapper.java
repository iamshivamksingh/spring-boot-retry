package com.example.demo.exception;

import com.example.demo.dto.ErrorResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author sksingh created on 01/02/24
 */
@RestControllerAdvice
@Order(200)
public class DefaultExceptionMapper {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> handleAllExceptions(Throwable t) {
        ErrorResponse errResponse = new ErrorResponse()
                .setStatus("failed")
                .setCode("DEMO-001")
                .setBody(new ErrorResponse.ErrorBody()
                                 .setDebugMsg(t.getMessage())
                                 .setErrorMsg(t.getLocalizedMessage())
                );

        return new ResponseEntity<>(errResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
