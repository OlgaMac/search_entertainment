package com.aston.search_entertainment.domain.dto.request;

import com.aston.search_entertainment.validation.annotation.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequest {

    @Email
    private String email;

    private String password;
}
