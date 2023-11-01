package com.app.Exception;

public class ErrorResponse {
    //create variables errorCode and errorMessage

    private int errorCode;
    private String errorMessage;

    //create constructor
    public ErrorResponse() {
        super();
    }
    public ErrorResponse(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    //generate getters and setters
    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    //generate toString() method
    @Override
    public String toString() {
        return "ErrorResponse [errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
    }

}
