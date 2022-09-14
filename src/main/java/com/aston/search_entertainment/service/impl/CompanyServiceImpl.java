package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import com.aston.search_entertainment.domain.entity.Company;
import com.aston.search_entertainment.domain.entity.CompanyPage;
import com.aston.search_entertainment.domain.entity.CompanySearchCriteria;
import com.aston.search_entertainment.domain.mapper.CompanyMapper;
import com.aston.search_entertainment.repository.CompanyRepository;
import com.aston.search_entertainment.repository.UserRepository;
import com.aston.search_entertainment.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
    private final UserRepository userRepository;

    private final CompanyCriteriaRepoService companyCriteriaRepoService;


    @Override
    public List<CompanyResponse> findAll() {
      return companyRepository.findAll()
              .stream()
              .map(companyMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyResponse findById(Long id) {
        return companyRepository.findById(id)
                .stream()
                .map(companyMapper::toResponse)
                .findAny().get();
    }

    @Transactional
    @Override
    public CompanyResponse save(CompanyRequest companyRequest) {
        Company company = companyMapper.fromRequest(companyRequest);
        companyRepository.save(company);
        return companyMapper.toResponse(company);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userRepository.findById(companyRepository.getCompanyById(id).getUserId().getId()).get().getCompanies().remove(companyRepository.getCompanyById(id));

        companyRepository.deleteById(id);
    }

    @Transactional
    @Override
    public CompanyResponse update(Long id, CompanyRequestUpdate companyRequestUpdate) {
        companyRepository.setCompanyInfoById(
                companyRequestUpdate.getName(),
                companyRequestUpdate.getLink(),
                companyRequestUpdate.getLocation(),
                companyRequestUpdate.getDocuments(),
                id);

        return companyMapper.toResponse(companyRepository.getCompanyById(id));
    }

    public Page<Company> getCompanies(CompanyPage companyPage,
                                      CompanySearchCriteria companySearchCriteria) {
        return companyCriteriaRepoService.findAllWithFilters(companyPage, companySearchCriteria);
    }
}
