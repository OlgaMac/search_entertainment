package com.aston.search_entertainment.controller;


import com.aston.search_entertainment.domain.dto.request.EntertainmentRequest;
import com.aston.search_entertainment.domain.dto.request.EntertainmentRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.EntertainmentResponse;
import com.aston.search_entertainment.service.EntertainmentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping(value = "/entertainments")
@RequiredArgsConstructor
@RestController
public class EntertainmentController {

    private final EntertainmentService entertainmentService;

    @ApiOperation(value = "Get all comments")
    @GetMapping
    List<EntertainmentResponse> getAllComments() {

        return entertainmentService.getListOfEntertainmentDto();
    }

    @ApiOperation(value = "Get entertainment by id")
    @GetMapping("/{id}")
    EntertainmentResponse getCommentById(@PathVariable(value = "id") Long id) {

        return entertainmentService.getById(id);
    }

    @ApiOperation(value = "Create entertainment")
    @PostMapping
    EntertainmentResponse createComment(@RequestBody EntertainmentRequest entertainmentRequest) {

        return entertainmentService.createEntertainment(entertainmentRequest);
    }

    @ApiOperation(value = "Edit entertainment")
    @PutMapping()
    EntertainmentResponse editComment(@RequestBody EntertainmentRequestUpdate entertainmentRequest) {

        return entertainmentService.editEntertainment(entertainmentRequest.getId(), entertainmentRequest);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteCommentById(@PathVariable Long id) {

        entertainmentService.deleteEntertainmentById(id);
        return ResponseEntity.ok("Entertainment delete successfully");
    }
}
