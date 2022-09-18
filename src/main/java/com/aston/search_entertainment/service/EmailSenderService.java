package com.aston.search_entertainment.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailSenderService {
    void send(String to, String subject, String message);
}
