package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import com.aston.search_entertainment.domain.entity.Company;
import com.aston.search_entertainment.domain.entity.User;
import com.aston.search_entertainment.domain.mapper.CompanyMapper;
import com.aston.search_entertainment.repository.CompanyRepository;
import com.aston.search_entertainment.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyResponse> findAll() {
      return companyRepository.findAll()
              .stream()
              .map(companyMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyResponse findById(long id) {
        return companyRepository.findById(id)
                .stream()
                .map(companyMapper::toResponse)
                .findAny().get();
    }

    @Override
    public CompanyResponse save(CompanyRequest companyRequest) {
        Company company = companyMapper.fromRequest(companyRequest);
        companyRepository.save(company);
        return companyMapper.toResponse(company);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public CompanyResponse update(Long id, CompanyRequestUpdate companyRequestUpdate) {
        companyRepository.setCompanyInfoById(companyRequestUpdate.getLocation(),
                companyRequestUpdate.getDocuments(),
                companyRequestUpdate.getLocation(),
                companyRequestUpdate.getName(),
                id);

        return companyMapper.toResponse(companyRepository.getCompanyBy(id));
    }
}
