package com.aston.search_entertainment.service;

public interface EmailSenderService {
    void send(String to, String subject, String message);
}
