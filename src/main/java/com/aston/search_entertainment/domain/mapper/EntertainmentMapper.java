package com.aston.search_entertainment.domain.mapper;


import com.aston.search_entertainment.domain.dto.request.EntertainmentRequest;
import com.aston.search_entertainment.domain.dto.response.EntertainmentResponse;
import com.aston.search_entertainment.domain.entity.Entertainment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EntertainmentMapper {

    Entertainment toEntertainment(EntertainmentRequest request);

    @InheritInverseConfiguration
    EntertainmentResponse toEntertainmentResponse(Entertainment entertainment);
}