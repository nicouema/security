package com.claro.security.service;

import com.claro.security.model.User;
import com.claro.security.response.AuthenticationResponse;
import com.claro.security.response.UserAndAuthenticationResponse;

public interface AuthenticationService {

        AuthenticationResponse prepareAuthenticationResponse(String username, String password);
        UserAndAuthenticationResponse prepareAuthentication(User user, AuthenticationResponse authenticationResponse);
}
