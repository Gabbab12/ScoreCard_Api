package com.example.scorecard_api.controller;

import com.example.scorecard_api.dto.responsedto.APIResponse;
import com.example.scorecard_api.exception.CustomException;
import com.example.scorecard_api.exception.ResourceNotFoundException;
import com.example.scorecard_api.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse<?>> resourceNotFoundException(ResourceNotFoundException exception){
        return new ResponseEntity<>(new APIResponse<>(true, exception.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<APIResponse<?>> customExceptionHandler(CustomException exception){
        return new ResponseEntity<>(new APIResponse<>(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<APIResponse<?>> userNotFoundException(UserNotFoundException exception){
        return new ResponseEntity<>(new APIResponse<>(true, exception.getMessage(), null), HttpStatus.BAD_REQUEST);
    }
}




