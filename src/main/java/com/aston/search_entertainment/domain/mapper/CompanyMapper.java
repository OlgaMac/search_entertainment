package com.aston.search_entertainment.domain.mapper;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import com.aston.search_entertainment.domain.entity.CompanyEntity;

public interface CompanyMapper {

    CompanyResponse toResponse(CompanyEntity userEntity);

    CompanyEntity fromRequest(CompanyRequest userRequest);

    CompanyEntity fromRequestUpdate(CompanyRequestUpdate userRequestUpdate);
}
