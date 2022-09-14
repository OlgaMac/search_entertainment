package com.aston.search_entertainment.domain.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
public class RegistrationRequest {

    private String email;

    private String password;

    private String firstName;

    private String lastName;
}
