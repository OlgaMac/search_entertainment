package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.request.EntertainmentRequest;
import com.aston.search_entertainment.domain.dto.request.EntertainmentRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.EntertainmentResponse;
import com.aston.search_entertainment.domain.entity.Entertainment;
import com.aston.search_entertainment.domain.mapper.EntertainmentMapper;
import com.aston.search_entertainment.repository.EntertainmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.aston.search_entertainment.generators.EntitiesGenerator.generateEntertainment;
import static com.aston.search_entertainment.generators.EntitiesGenerator.generateEntertainmentRequest;
import static com.aston.search_entertainment.generators.EntitiesGenerator.generateEntertainmentResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class EntertainmentServiceImplTest {

    private Entertainment entertainment;

    private EntertainmentRequest entertainmentRequest;

    private EntertainmentResponse entertainmentResponse;

    private EntertainmentRequestUpdate entertainmentRequestUpdate;

    @InjectMocks
    EntertainmentServiceImpl entertainmentService;

    @Mock
    EntertainmentRepository entertainmentRepository;

    @Mock
    EntertainmentMapper entertainmentMapper;

    @BeforeEach
    void initialize() {
        entertainment = generateEntertainment();
        entertainmentRequest = generateEntertainmentRequest();
        entertainmentResponse = generateEntertainmentResponse();
        entertainmentRequestUpdate = new EntertainmentRequestUpdate();
    }

    void assertEqualsRequestAndResponse(EntertainmentRequest request, EntertainmentResponse response) {
        assertEquals(request.getCompany_id(), response.getCompany_id());
        assertEquals(request.getRating(), response.getRating());
        assertEquals(request.getDocuments(), response.getDocuments());
        assertEquals(request.getLocation(), response.getLocation());
        assertEquals(request.getName(), response.getName());
        assertEquals(request.getUrl(), response.getUrl());
    }

    @Test
    void getById() {
        Mockito
                .when(entertainmentRepository.getEntertainmentById(1L))
                .thenReturn(entertainment);

        Mockito
                .when(entertainmentMapper.toEntertainmentResponse(entertainment))
                .thenReturn(entertainmentResponse);

        EntertainmentResponse result = entertainmentService.getById(1L);

        assertEquals(1L, result.getId());

    }

    @Test
    void getListOfCommentDto() {

        entertainmentService.getListOfEntertainmentDto();

        Mockito.verify(entertainmentRepository, Mockito.times(1))
                .findAll();

    }

    @Test
    void createComment() {
        Mockito
                .when(entertainmentRepository.save(entertainment))
                .thenReturn(entertainment);

        Mockito
                .when(entertainmentMapper.toEntertainment(entertainmentRequest))
                .thenReturn(entertainment);

        Mockito
                .when(entertainmentMapper.toEntertainmentResponse(entertainment))
                .thenReturn(entertainmentResponse);

        EntertainmentResponse result = entertainmentService.createEntertainment(entertainmentRequest);

        assertEqualsRequestAndResponse(entertainmentRequest, result);

        Mockito
                .verify(entertainmentRepository, Mockito.times(1))
                .save(entertainment);
    }

    @Test
    void editComment() {
        Mockito
                .when(entertainmentRepository.getEntertainmentById(1L))
                .thenReturn(entertainment);

        entertainmentService.editEntertainment(1L, entertainmentRequestUpdate);

        Mockito.verify(entertainmentRepository, Mockito.times(1))
                .setEntertainmentInfoById(entertainmentRequestUpdate.getLocation(),
                        entertainmentRequestUpdate.getDocuments(),
                        entertainmentRequestUpdate.getUrl(),
                        1L);

        Mockito.verify(entertainmentMapper, Mockito.times(1))
                .toEntertainmentResponse(entertainment);
    }

    @Test
    void deleteCommentById() {
        entertainmentService.deleteEntertainmentById(1L);

        Mockito
                .verify(entertainmentRepository, Mockito.times(1))
                .deleteById(1L);
    }
}
