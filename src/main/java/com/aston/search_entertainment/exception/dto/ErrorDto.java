package com.aston.search_entertainment.exception.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


// пока не исользуется
@Getter
@Setter(AccessLevel.PUBLIC)
@RequiredArgsConstructor
public class ErrorDto {
    private final String errorCode;
    private final String errorMessage;
}
