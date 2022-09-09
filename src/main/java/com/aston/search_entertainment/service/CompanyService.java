package com.aston.search_entertainment.service;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CompanyService {

    List<CompanyResponse> findAll ();
    CompanyResponse findById(long id) throws ChangeSetPersister.NotFoundException;
    CompanyResponse save(CompanyRequest companyRequest);
    void deleteById(Long id);
    CompanyResponse update(Long id, CompanyRequestUpdate companyRequestUpdate);

}
