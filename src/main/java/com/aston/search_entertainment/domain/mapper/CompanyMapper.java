package com.aston.search_entertainment.domain.mapper;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import com.aston.search_entertainment.domain.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring"
        , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CompanyMapper {

    CompanyResponse toResponse(Company userEntity);

    Company fromRequest(CompanyRequest userRequest);

    Company fromRequestUpdate(CompanyRequestUpdate userRequestUpdate);
}
