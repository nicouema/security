package com.claro.nicouema.service;

import com.claro.nicouema.model.User;
import com.claro.nicouema.requests.CreateUserRequest;
import com.claro.nicouema.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User registerUser(CreateUserRequest user);

    User registerAdmin(CreateUserRequest createUserRequest);

    List<UserResponse> getUsersOfRole(String role);
}
