package com.aston.search_entertainment.domain.dto.request;

import com.aston.search_entertainment.domain.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyRequestUpdate {
    private long id;
    private String name;
    private UserEntity userId;
    private String location;
    private String documents;
}
