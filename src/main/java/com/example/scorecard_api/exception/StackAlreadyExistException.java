package com.example.scorecard_api.exception;

public class StackAlreadyExistException extends RuntimeException{
    public StackAlreadyExistException(String message) {
        super(message);
    }
}
