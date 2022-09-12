package com.aston.search_entertainment.domain.dto.request;

import com.aston.search_entertainment.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyRequest {

    private String name;
    private String documents;
    private String location;
    private String link;
    private Long userId;
    private Boolean active;
}
