package com.mobile.SpringMobileAPI.exception;

public class DataNotFoundException extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public DataNotFoundException(String message){
        super(message);
    }
}
