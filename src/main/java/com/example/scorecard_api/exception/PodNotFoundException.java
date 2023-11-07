package com.example.scorecard_api.exception;

public class PodNotFoundException extends RuntimeException{
   public PodNotFoundException(String message){
            super(message);
   }
}
