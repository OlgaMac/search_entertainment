package com.aston.search_entertainment.domain.mapper.impl;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import com.aston.search_entertainment.domain.entity.CompanyEntity;
import com.aston.search_entertainment.domain.mapper.CompanyMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapperImpl implements CompanyMapper {
    private final ObjectMapper objectMapper;

    public CompanyMapperImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public CompanyResponse toResponse(CompanyEntity companyEntity) {
        CompanyResponse companyResponse = new CompanyResponse();
        return companyResponse
                .setId(companyEntity.getId())
                .setName(companyEntity.getName())
                .setLocation(companyEntity.getLocation())
                .setDocuments(companyEntity.getDocuments());
    }

    @Override
    public CompanyEntity fromRequest(CompanyRequest companyRequest) {
        return objectMapper.convertValue(companyRequest, CompanyEntity.class);
    }

    @Override
    public CompanyEntity fromRequestUpdate(CompanyRequestUpdate companyRequestUpdate) {
        return objectMapper.convertValue(companyRequestUpdate, CompanyEntity.class);
    }
}
