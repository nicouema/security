package com.claro.security.controller.apis;

import com.claro.security.requests.AuthenticationRequest;
import com.claro.security.requests.CreateUserRequest;
import com.claro.security.response.AuthenticationResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

@SecurityRequirement(name = "bearerAuth")
public interface AuthenticationApi {

    String AUTH_URL = "/auth";


    ResponseEntity<AuthenticationResponse> loginUser(@Valid AuthenticationRequest request);

    ResponseEntity<Object> registerUser(@Valid CreateUserRequest userRequest);

    ResponseEntity<Object> getTest();

    ResponseEntity<Object> getTest2();

}
