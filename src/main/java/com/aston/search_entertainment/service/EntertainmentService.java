package com.aston.search_entertainment.service;

import com.aston.search_entertainment.domain.dto.request.CommentRequestForEdit;
import com.aston.search_entertainment.domain.dto.request.EntertainmentRequest;
import com.aston.search_entertainment.domain.dto.request.EntertainmentRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CommentResponse;
import com.aston.search_entertainment.domain.dto.response.EntertainmentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntertainmentService {
    List<EntertainmentResponse> getListOfEntertainmentDto();

    EntertainmentResponse getById(Long id);

    EntertainmentResponse createEntertainment(EntertainmentRequest entertainmentRequest);

    EntertainmentResponse editEntertainment(Long id, EntertainmentRequestUpdate entertainmentRequest);

    void deleteEntertainmentById(Long id);
}

