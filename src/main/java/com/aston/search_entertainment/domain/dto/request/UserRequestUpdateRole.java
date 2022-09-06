package com.aston.search_entertainment.domain.dto.request;

import com.aston.search_entertainment.domain.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequestUpdateRole {

    private Long id;

    private String role;
}
