package com.aston.search_entertainment.domain.dto.request;

import com.aston.search_entertainment.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntertainmentRequest {
    private long id;
    private String name;
    private User company_id;
    private String location;
    private String documents;
    private String url;
    private Date date;
    private Double rating;
}
