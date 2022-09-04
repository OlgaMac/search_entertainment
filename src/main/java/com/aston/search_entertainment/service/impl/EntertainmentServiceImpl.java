package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.response.EntertainmentResponse;
import com.aston.search_entertainment.domain.mapper.EntertainmentMapper;
import com.aston.search_entertainment.repository.EntertainmentRepository;
import com.aston.search_entertainment.service.EntertainmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EntertainmentServiceImpl implements EntertainmentService {

    private final EntertainmentRepository entertainmentRepository;
    private final EntertainmentMapper entertainmentMapper;

    public List<EntertainmentResponse> getListOfEntertainmentDto() {
        return entertainmentRepository.findAll()
                .stream()
                .map(entertainmentMapper::toEntertainmentResponse)
                .collect(Collectors.toList());
    }
}
