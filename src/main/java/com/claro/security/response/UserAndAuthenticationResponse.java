package com.claro.security.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAndAuthenticationResponse {

    private UserResponse userResponse;
    private AuthenticationResponse authenticationResponse;
}
