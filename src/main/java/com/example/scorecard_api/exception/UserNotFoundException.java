package com.example.scorecard_api.exception;

public class UserNotFoundException  extends  RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }

}
