package com.aston.search_entertainment.domain.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class CompanyResponse {

    private Long id;
    private String name;
    private Long userId;
    private String location;
    private String documents;
}
