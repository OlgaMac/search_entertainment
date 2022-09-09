package com.aston.search_entertainment.domain.dto.request;

import com.aston.search_entertainment.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyRequestUpdate {

    private long id;

    private String name;

    private String location;

    private String documents;
}
