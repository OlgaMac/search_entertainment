package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.request.CommentRequestForEdit;
import com.aston.search_entertainment.domain.dto.request.EntertainmentRequest;
import com.aston.search_entertainment.domain.dto.request.EntertainmentRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CommentResponse;
import com.aston.search_entertainment.domain.dto.response.EntertainmentResponse;
import com.aston.search_entertainment.domain.entity.Comment;
import com.aston.search_entertainment.domain.entity.Entertainment;
import com.aston.search_entertainment.domain.mapper.EntertainmentMapper;
import com.aston.search_entertainment.repository.EntertainmentRepository;
import com.aston.search_entertainment.service.EntertainmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EntertainmentServiceImpl implements EntertainmentService {

    private final EntertainmentRepository entertainmentRepository;

    private final EntertainmentMapper entertainmentMapper;

    @Override
    public List<EntertainmentResponse> getListOfEntertainmentDto() {
        return entertainmentRepository.findAll()
                .stream()
                .map(entertainmentMapper::toEntertainmentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EntertainmentResponse getById(Long id) {
        return entertainmentMapper.toEntertainmentResponse(entertainmentRepository.getEntertainmentById(id));
    }

    @Override
    public EntertainmentResponse createEntertainment(EntertainmentRequest entertainmentRequest) {
        Entertainment entertainment = entertainmentMapper.toEntertainment(entertainmentRequest);
        entertainmentRepository.save(entertainment);
        return entertainmentMapper.toEntertainmentResponse(entertainment);
    }

    @Override
    public EntertainmentResponse editEntertainment(Long id, EntertainmentRequestUpdate entertainmentRequest) {
        entertainmentRepository.setEntertainmentInfoById(entertainmentRequest.getLocation(),
                entertainmentRequest.getDocuments(),
                entertainmentRequest.getUrl(),
                id);

        return entertainmentMapper.toEntertainmentResponse(entertainmentRepository.getEntertainmentById(id));
    }

    @Override
    public void deleteEntertainmentById(Long id) {
        entertainmentRepository.deleteById(id);
    }
}
