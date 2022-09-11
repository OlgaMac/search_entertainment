package com.aston.search_entertainment.domain.dto.request;

import com.aston.search_entertainment.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class CompanyRequestUpdate {

    private Long id;

    private String name;

    private String documents;

    private String location;

    private String link;

    private Long userId;

    private boolean active;

}
