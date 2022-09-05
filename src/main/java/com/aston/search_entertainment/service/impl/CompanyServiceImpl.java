package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import com.aston.search_entertainment.domain.mapper.CompanyMapper;
import com.aston.search_entertainment.repository.CompanyRepository;
import com.aston.search_entertainment.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyResponse> getListOfCompanyDto() {
        return null;
    }

    @Override
    public CompanyResponse createCompany(CompanyRequest companyRequest) {
        return null;
    }

    @Override
    public CompanyResponse editCompany(Long id, CompanyRequestUpdate companyRequestUpdate) {
        return null;
    }

    @Override
    public CompanyResponse getById(Long id) {
        return null;
    }

    @Override
    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }
}
