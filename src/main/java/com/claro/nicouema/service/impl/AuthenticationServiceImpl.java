package com.claro.nicouema.service.impl;

import com.claro.nicouema.mappers.UserMapper;
import com.claro.nicouema.model.User;
import com.claro.nicouema.response.AuthenticationResponse;
import com.claro.nicouema.response.UserAndAuthenticationResponse;
import com.claro.nicouema.response.UserResponse;
import com.claro.nicouema.service.AuthenticationService;
import com.claro.nicouema.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserMapper mapper;

    public AuthenticationResponse prepareAuthenticationResponse(String username, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        if (authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails users) {

            final String token = jwtUtils.generateToken(users);

            return AuthenticationResponse.builder()
                    .token(token)
                    .expirationDate(jwtUtils.extractExpiration(token))
                    .build();
        }

        throw new AccessDeniedException("error in the authentication process");

    }

    @Override
    public UserAndAuthenticationResponse prepareAuthentication(User user, AuthenticationResponse authenticationResponse) {
        UserResponse userResponse = mapper.userToUserResponse(user);
        return new UserAndAuthenticationResponse(userResponse, authenticationResponse);

    }
}
