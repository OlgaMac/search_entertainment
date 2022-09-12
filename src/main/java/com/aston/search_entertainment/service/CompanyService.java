package com.aston.search_entertainment.service;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;

import java.util.List;

public interface CompanyService {

    /**
     * Find all Company.
     *
     * @return list of CompanyDto
     */

    List<CompanyResponse> getListOfCompanyDto();

    CompanyResponse createCompany(CompanyRequest companyRequest);

    CompanyResponse editCompany(Long id, CompanyRequestUpdate companyRequestUpdate);

    CompanyResponse getById(Long id);

    void deleteCompanyById(Long id);

}
