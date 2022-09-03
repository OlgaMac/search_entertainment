package com.aston.search_entertainment.domain.dto.request;

import com.aston.search_entertainment.domain.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestUpdate {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Timestamp created;
    private Role role;
}
