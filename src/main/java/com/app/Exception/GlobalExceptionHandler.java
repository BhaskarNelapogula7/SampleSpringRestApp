package com.app.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //create a method to handle the EmployeeNotFoundException using ErrorResponse
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException empNotFoundException){
        //create an object of ErrorResponse class and set the error message
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(empNotFoundException.getMessage());
        //return the ResponseEntity object
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    //create a method to handle the Exception using ErrorResponse
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        //create an object of ErrorResponse class and set the error message
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorMessage(exception.getMessage());
        //return the ResponseEntity object
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
