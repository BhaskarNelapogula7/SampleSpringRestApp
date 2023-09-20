package com.app.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //create a method to handle the EmployeeNotFoundException using ErrorResponse

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(HttpStatus.NOT_FOUND.value());
        response.setErrorMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
    }

    //create a method to handle the general exception using ErrorResponse
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setErrorMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}