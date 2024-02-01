package com.example.demo.exception;

import com.example.demo.dto.ErrorResponse;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author sksingh created on 01/02/24
 */
@RestControllerAdvice
@Order(value = 100)
public class ExceptionMapper {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleMethodArgumentException(HttpMessageNotReadableException e) {
        ErrorResponse errResponse = new ErrorResponse()
                .setStatus("failed")
                .setCode("DEMO-002")
                .setBody(new ErrorResponse.ErrorBody()
                                 .setDebugMsg(e.getMostSpecificCause().getMessage())
                                 .setErrorMsg("Invalid payload. Check the request")
                );

        return new ResponseEntity<>(errResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MismatchedInputException.class)
    public ResponseEntity<ErrorResponse> handleMismatchInputException(MismatchedInputException e) {
        ErrorResponse errResponse = new ErrorResponse()
                .setStatus("failed")
                .setCode("DEMO-003")
                .setBody(new ErrorResponse.ErrorBody()
                                 .setDebugMsg(e.getMessage())
                                 .setErrorMsg("Deserialization issue")
                );

        return new ResponseEntity<>(errResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
