package com.aston.search_entertainment.domain.mapper;

import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.request.UserRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import com.aston.search_entertainment.domain.entity.Company;
import com.aston.search_entertainment.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring"
        , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
        , uses = UserFromRepoMapper.class)
public interface CompanyMapper {

    @Mapping(target = "userId", expression = "java(company.getUserId().getId())")
    CompanyResponse toResponse(Company company);

    @Mapping(target = "userId", source = "userId", qualifiedByName = "getUserFromRepo")
    Company fromRequest(CompanyRequest companyRequest);

//    Company fromRequestUpdate(CompanyRequestUpdate companyRequestUpdate);

}
