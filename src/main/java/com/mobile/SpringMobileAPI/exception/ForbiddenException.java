package com.mobile.SpringMobileAPI.exception;

public class ForbiddenException extends RuntimeException{
   public static final long serialVersionUID =1;
    public ForbiddenException(String message){
        super(message);
    }
}
