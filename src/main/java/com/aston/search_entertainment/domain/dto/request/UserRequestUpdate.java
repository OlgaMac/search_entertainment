package com.aston.search_entertainment.domain.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestUpdate {
    private String email;
    private String firstName;
    private String lastName;
    private String role;
}
