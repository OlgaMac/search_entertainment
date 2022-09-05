package com.aston.search_entertainment.domain.dto.response;

import com.aston.search_entertainment.domain.entity.User;
import com.aston.search_entertainment.domain.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class EntertainmentResponse {

    private Long id;

    private String name;

    private Company company_id;

    private String location;

    private String documents;

    private String url;

    private Date date;

    private Double rating;
}
