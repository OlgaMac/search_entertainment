package com.aston.search_entertainment.controller;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import com.aston.search_entertainment.domain.entity.Company;
import com.aston.search_entertainment.domain.entity.CompanyPage;
import com.aston.search_entertainment.domain.entity.CompanySearchCriteria;
import com.aston.search_entertainment.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

@RequestMapping(value = "/company/criteria")
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

    @ApiOperation(value = "Get comment by id")
    @GetMapping("/{id}")
    CompanyResponse getCompanyById(@PathVariable(value = "id") Long id) throws ChangeSetPersister.NotFoundException {
        log.info("get company by id");
        return companyService.findById(id);
    }

    @ApiOperation(value = "Create comment")
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

    @ApiOperation(value = "Delete company")
    @DeleteMapping({"/{id}"})
    ResponseEntity<String> deleteCompanyById(@PathVariable(value = "id") Long id) {
        log.info("Receiving request for deleting company with id: {}", id);
        companyService.deleteById(id);
        return ResponseEntity.ok("Company delete successfully");
    }

    @ApiOperation(value = "Search companies by company name with the use of API Criteria")
    @GetMapping("/criteria")
    public ResponseEntity<Page<Company>> getCompanies(CompanyPage companyPage,
                                                      CompanySearchCriteria companySearchCriteria) {
        log.info("Search companies by name");
        return new ResponseEntity<>(companyService.getCompanies(companyPage, companySearchCriteria),
                HttpStatus.OK);
    }
}
