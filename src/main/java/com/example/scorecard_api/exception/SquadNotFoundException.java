package com.example.scorecard_api.exception;

public class SquadNotFoundException extends RuntimeException{
    public SquadNotFoundException(String message) {
        super(message);
    }
}
