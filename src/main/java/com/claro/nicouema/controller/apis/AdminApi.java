package com.claro.nicouema.controller.apis;

import com.claro.nicouema.requests.CreateUserRequest;
import com.claro.nicouema.response.UserAndAuthenticationResponse;
import com.claro.nicouema.response.UserResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SecurityRequirement(name = "bearerAuth")
public interface AdminApi {

    String ADMIN_URL = "/admin";

    ResponseEntity<UserAndAuthenticationResponse> registerAdmin(@Valid CreateUserRequest createUserRequest);

    ResponseEntity<List<UserResponse>> getAllAdmins();
}
