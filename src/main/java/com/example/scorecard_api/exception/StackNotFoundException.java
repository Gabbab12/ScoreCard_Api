package com.example.scorecard_api.exception;

public class StackNotFoundException extends RuntimeException{
    public StackNotFoundException(String message) {
        super(message);
    }
}
