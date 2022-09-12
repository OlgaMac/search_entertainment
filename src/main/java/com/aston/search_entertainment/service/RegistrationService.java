package com.aston.search_entertainment.service;


import com.aston.search_entertainment.domain.dto.request.RegistrationRequest;

public interface RegistrationService {
    void register(RegistrationRequest request);

    void confirm(String token);
}

