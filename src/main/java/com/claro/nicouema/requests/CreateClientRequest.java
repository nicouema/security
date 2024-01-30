package com.claro.nicouema.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateClientRequest {

    private String idType;
    private String idNum;
    private String name;
    private String lastname;
    private LocalDate birthdate;
}
