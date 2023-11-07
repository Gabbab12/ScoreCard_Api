package com.example.scorecard_api.exception;

public class AccountNotActiveException extends RuntimeException{
    public AccountNotActiveException(String message){
        super(message);
    }
}
