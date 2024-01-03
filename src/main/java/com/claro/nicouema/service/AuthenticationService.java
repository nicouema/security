package com.claro.nicouema.service;

import com.claro.nicouema.model.User;
import com.claro.nicouema.response.AuthenticationResponse;
import com.claro.nicouema.response.UserAndAuthenticationResponse;

public interface AuthenticationService {

        AuthenticationResponse prepareAuthenticationResponse(String username, String password);
        UserAndAuthenticationResponse prepareAuthentication(User user, AuthenticationResponse authenticationResponse);
}
