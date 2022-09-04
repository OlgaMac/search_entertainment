package com.aston.search_entertainment.service;

import com.aston.search_entertainment.domain.dto.response.EntertainmentResponse;

import java.util.List;

public interface EntertainmentService {
    public List<EntertainmentResponse> getListOfEntertainmentDto();
}
