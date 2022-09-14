package com.aston.search_entertainment.domain.dto.request;

import com.aston.search_entertainment.domain.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EntertainmentRequestUpdate {

    private Long id;

    private String location;

    private String documents;

    private String url;

}
