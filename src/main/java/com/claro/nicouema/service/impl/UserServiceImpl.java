package com.claro.nicouema.service.impl;

import com.claro.nicouema.exception.ConflictException;
import com.claro.nicouema.mappers.UserDTOsMapper;
import com.claro.nicouema.model.User;
import com.claro.nicouema.persistence.RoleRepository;
import com.claro.nicouema.persistence.UserRepository;
import com.claro.nicouema.requests.CreateUserRequest;
import com.claro.nicouema.response.UserResponse;
import com.claro.nicouema.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDTOsMapper dtoMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    private final PasswordEncoder passwordEncoder;

    @Value("${default.role}")
    private String defaultRoleUser;

    @Value("${admin.role}")
    private String adminRoleUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public User registerUser(CreateUserRequest createUserRequest) {
        return register(createUserRequest, defaultRoleUser);
    }

    @Override
    public User registerAdmin(CreateUserRequest createUserRequest) {
        return register(createUserRequest, adminRoleUser);
    }

    private User register(CreateUserRequest createUserRequest, String role) {
        User user = dtoMapper.createUserRequestToUser(createUserRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleRepository.getRoleById(role));

        try {
            userRepository.createNewUser(user);
        } catch (DuplicateKeyException e) {
            throw new ConflictException("User: " + user.getUsername() + " already exists");
        }

        return user;
    }

    @Override
    public List<UserResponse> getUsersOfRole(String role) {
        List<User> admins = userRepository.getUsersWithRole(role);

        return dtoMapper.userListToUserResponseList(admins);
    }
}
