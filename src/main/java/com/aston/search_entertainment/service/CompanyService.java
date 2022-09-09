package com.aston.search_entertainment.service;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    List<CompanyResponse> findAll ();
    CompanyResponse findById(long id) ;
    CompanyResponse save(CompanyRequest companyRequest);
    void deleteById(Long id);
    CompanyResponse update(Long id, CompanyRequestUpdate companyRequestUpdate);

}
