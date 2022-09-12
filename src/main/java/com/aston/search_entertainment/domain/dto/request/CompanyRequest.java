package com.aston.search_entertainment.domain.dto.request;

import com.aston.search_entertainment.domain.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyRequest {

    private long id;

    private String name;

    private UserEntity userId;
    private String location;

    private String documents;
}
