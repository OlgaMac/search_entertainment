package com.aston.search_entertainment.domain.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestUpdate {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate created;
    private String role;
}
