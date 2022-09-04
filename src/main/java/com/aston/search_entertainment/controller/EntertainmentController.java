package com.aston.search_entertainment.controller;

import com.aston.search_entertainment.domain.dto.response.EntertainmentResponse;

import com.aston.search_entertainment.service.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/entertainments")
public class EntertainmentController {

    EntertainmentService entertainmentService;

    @Autowired
    public EntertainmentController(EntertainmentService entertainmentService) {
        this.entertainmentService = entertainmentService;
    }

    @GetMapping()
    public List<EntertainmentResponse> getAllEntertainments() {
        return entertainmentService.getListOfEntertainmentDto();
    }
}
