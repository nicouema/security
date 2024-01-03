package com.claro.nicouema.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateUserRequest {

    @NotBlank(message = "The username must not be blank")
    private String username;
    @NotBlank(message = "The password must not be blank")
    private String password;

    @Email(message="Please provide a valid email address")
    private String email;
}
