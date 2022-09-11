package com.aston.search_entertainment.domain.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EntertainmentRequestUpdate {



    private String location;

    private String documents;

    private String url;

}
