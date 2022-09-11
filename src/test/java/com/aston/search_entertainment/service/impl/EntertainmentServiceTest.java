package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.response.EntertainmentResponse;
import com.aston.search_entertainment.domain.mapper.EntertainmentMapper;
import com.aston.search_entertainment.repository.EntertainmentRepository;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@RequiredArgsConstructor
public class EntertainmentServiceTest {


    private final EntertainmentRepository entertainmentRepository;
    private final EntertainmentMapper entertainmentMapper;

    @Test
    public EntertainmentResponse getByIdTest(Long id) {
        return entertainmentMapper.toEntertainmentResponse(entertainmentRepository.findEntertainmentById(id));
    }
}
