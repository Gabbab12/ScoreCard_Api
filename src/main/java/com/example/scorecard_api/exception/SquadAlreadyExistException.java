package com.example.scorecard_api.exception;

public class SquadAlreadyExistException extends RuntimeException{
    public SquadAlreadyExistException(String message) {
        super(message);
    }
}
