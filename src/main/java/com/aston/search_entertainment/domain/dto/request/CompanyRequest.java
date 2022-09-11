package com.aston.search_entertainment.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyRequest {

    private String name;

    private String documents;

    private String location;

    private String link;

    private Long userId;

    private boolean active;
}
