package com.aston.search_entertainment.domain.dto.response;

import com.aston.search_entertainment.domain.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Accessors
public class UserResponse {
    private long id;
    private String email;
    private Role role;
    private String firstName;
    private String lastName;
    private Timestamp created;
}
