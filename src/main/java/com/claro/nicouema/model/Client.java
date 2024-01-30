package com.claro.nicouema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {

    private String idType;
    private String idNum;
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private User user;

    public String getUsername() {
        return user.getUsername();
    }

    public Integer calculateAge() {
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthdate, currentDate);
        return period.getYears();
    }
}
