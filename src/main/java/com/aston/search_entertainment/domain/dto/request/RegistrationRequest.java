package com.aston.search_entertainment.domain.dto.request;

import com.aston.search_entertainment.validation.annotation.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
public class RegistrationRequest {

    @Email
    private String email;

    private String password;

    private String firstName;

    private String lastName;
}
