package com.aston.search_entertainment.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntertainmentRequest {



    private String name;

    private Long company_id;

    private String location;

    private String documents;

    private String url;

    private Double rating;
}
