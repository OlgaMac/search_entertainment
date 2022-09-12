package com.aston.search_entertainment.domain.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyRequestUpdate {

    private Long id;

    private String name;

    private String link;

    private String location;

    private String documents;
}
