package com.claro.nicouema.controller.apis;

import com.claro.nicouema.requests.AuthenticationRequest;
import com.claro.nicouema.requests.CreateUserRequest;
import com.claro.nicouema.response.AuthenticationResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

@SecurityRequirement(name = "bearerAuth")
public interface AuthenticationApi {

    ResponseEntity<AuthenticationResponse> loginUser(@Valid AuthenticationRequest request);

    ResponseEntity<Object> registerUser(@Valid CreateUserRequest userRequest);

    ResponseEntity<Object> getTest();

    ResponseEntity<Object> getTest2();

}
