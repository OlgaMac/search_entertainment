package com.aston.search_entertainment.controller;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import com.aston.search_entertainment.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//dsfa;sdfjas;dfj
import java.util.List;

@RequestMapping(value = "/company")
@RequiredArgsConstructor
@RestController
@Slf4j
public class CompanyController {

    private final CompanyService companyService;

    @ApiOperation(value = "Get all company")
    @GetMapping
    List<CompanyResponse> getAllCompany() {
        log.info("get all comments");
        return companyService.findAll();
    }

    @ApiOperation(value = "Get company by id")
    @GetMapping("/{id}")
    CompanyResponse getCompanyById(@PathVariable(value = "id") Long id) {
        log.info("get company by id");
        return companyService.findById(id);
    }

    @ApiOperation(value = "Create company")
    @PostMapping
    CompanyResponse createCompany(@RequestBody CompanyRequest companyRequest) {
        log.info("Receiving request for creating company: {}", companyRequest);
        return companyService.save(companyRequest);
    }

    @ApiOperation(value = "Edit company")
    @PutMapping()
    CompanyResponse editCompany(@RequestBody CompanyRequestUpdate companyRequestUpdate) {
        log.info("Receiving request for edit company with id: {}", companyRequestUpdate);
        return companyService.update(companyRequestUpdate.getId(), companyRequestUpdate);
    }

    @DeleteMapping({"/{id}"})
    ResponseEntity<String> deleteCompanyById(@PathVariable(value = "id") Long id) {
        log.info("Receiving request for deleting company with id: {}", id);
        companyService.deleteById(id);
        return ResponseEntity.ok("Company delete successfully");
    }
}
