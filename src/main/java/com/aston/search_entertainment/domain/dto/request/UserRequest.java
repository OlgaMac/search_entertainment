package com.aston.search_entertainment.domain.dto.request;

import com.aston.search_entertainment.validation.annotation.Email;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
public class UserRequest {

    @Email
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String role;

    private boolean enable;
}
