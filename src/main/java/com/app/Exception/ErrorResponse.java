package com.app.Exception;

public class ErrorResponse {
    //create variables errorCode and errorMessage
    private int errorCode;
    private String errorMessage;
    //provide getters and setters

    public int getErrorCode() {
        return errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    //add toString() method
    @Override
    public String toString() {
        return "ErrorResponse [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
    }
}
