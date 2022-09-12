package com.aston.search_entertainment.domain.mapper;


import com.aston.search_entertainment.domain.dto.request.CompanyRequest;
import com.aston.search_entertainment.domain.dto.request.CompanyRequestUpdate;
import com.aston.search_entertainment.domain.dto.response.CompanyResponse;
import com.aston.search_entertainment.domain.entity.Company;
import com.aston.search_entertainment.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;


@Mapper(componentModel = "spring"
        , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = UserFromRepoMapper.class)
public interface CompanyMapper {

    @Mapping(source = "userId", target = "userId", qualifiedByName = "getIdFromUser")
    CompanyResponse toResponse(Company company);

    @Mapping(source = "userId", target = "userId", qualifiedByName = "getUserFromRepo")
    Company fromRequest(CompanyRequest companyRequest);

    @Named("getIdFromUser")
    default Long map(UserEntity value){
        return value.getId();
    }

    Company fromRequestUpdate(CompanyRequestUpdate companyRequestUpdate);
}
