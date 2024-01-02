package com.claro.security.controller.apis;

import com.claro.security.requests.CreateUserRequest;
import com.claro.security.response.UserAndAuthenticationResponse;
import com.claro.security.response.UserResponse;
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
