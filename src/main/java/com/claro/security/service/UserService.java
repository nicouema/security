package com.claro.security.service;

import com.claro.security.model.User;
import com.claro.security.requests.CreateUserRequest;
import com.claro.security.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User registerUser(CreateUserRequest user);

    User registerAdmin(CreateUserRequest createUserRequest);

    List<UserResponse> getUsersOfRole(String role);
}
