package com.aston.search_entertainment.service;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import com.aston.search_entertainment.domain.entity.Company;
import com.aston.search_entertainment.domain.entity.CompanyPage;
import com.aston.search_entertainment.domain.entity.CompanySearchCriteria;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CompanyService {

    List<CompanyResponse> findAll ();
    CompanyResponse findById(Long id) throws ChangeSetPersister.NotFoundException;
    CompanyResponse save(CompanyRequest companyRequest);

    void deleteById(Long id);

    CompanyResponse update(Long id, CompanyRequestUpdate companyRequestUpdate);

    Page<Company> getCompanies(CompanyPage companyPage,
                               CompanySearchCriteria companySearchCriteria);
}
