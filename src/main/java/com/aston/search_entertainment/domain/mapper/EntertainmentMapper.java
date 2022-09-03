package com.aston.search_entertainment.domain.mapper;


import com.aston.search_entertainment.domain.dto.request.EntertainmentRequest;
import com.aston.search_entertainment.domain.dto.response.EntertainmentResponse;
import com.aston.search_entertainment.domain.entity.EntertainmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EntertainmentMapper {

    EntertainmentEntity toEntertainment(EntertainmentRequest request);

    EntertainmentResponse toEntertainmentResponse(EntertainmentEntity entertainment);
}