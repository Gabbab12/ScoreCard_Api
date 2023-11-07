package com.example.scorecard_api.service;



public interface EmailService {


    boolean sendEmail(String body, String subject, String email);
}

