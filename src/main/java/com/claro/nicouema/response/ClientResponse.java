package com.claro.nicouema.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClientResponse {

    private String name;
    private String lastname;
    private LocalDate birthdate;
    private Integer age;

}
