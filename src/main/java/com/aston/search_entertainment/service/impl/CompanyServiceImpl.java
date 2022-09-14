package com.aston.search_entertainment.service.impl;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import com.aston.search_entertainment.domain.entity.Comment;
import com.aston.search_entertainment.domain.entity.Company;
import com.aston.search_entertainment.domain.mapper.CompanyMapper;
import com.aston.search_entertainment.exception.EntityNotFoundException;
import com.aston.search_entertainment.repository.CompanyRepository;
import com.aston.search_entertainment.repository.UserRepository;
import com.aston.search_entertainment.service.CompanyService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    private final UserRepository userRepository;

    @Override
    public List<CompanyResponse> findAll() {
      return companyRepository.findAll()
              .stream()
              .map(companyMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyResponse findById(Long id) {
        Company company = companyRepository.findById(id).orElse(null);
        if (company == null) {
            throw new NoSuchElementException("Company not found with id : " + id);
        }
        return companyMapper.toResponse(company);
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
        userRepository.getUserEntityById(companyRepository.getCompanyById(id).getUserId().getId()).getCompanies().remove(companyRepository.getCompanyById(id));

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
}
