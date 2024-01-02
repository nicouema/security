package com.claro.security.requests;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthenticationRequest {

    @NotBlank(message = "The username must not be blank")
    private String username;
    @NotBlank(message = "The password must not be blank")
    private String password;

}
