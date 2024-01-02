package com.claro.security.service.impl;

import com.claro.security.mappers.UserDTOsMapper;
import com.claro.security.model.Role;
import com.claro.security.model.User;
import com.claro.security.persistence.CreateUserSupplier;
import com.claro.security.persistence.GetUsersOfRoleSupplier;
import com.claro.security.persistence.LoadUserSupplier;
import com.claro.security.requests.CreateUserRequest;
import com.claro.security.response.UserResponse;
import com.claro.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDTOsMapper mapper;

    private final CreateUserSupplier createUser;
    private final LoadUserSupplier getUser;
    private final Function<String, Role> getRoleIfExists;
    private final GetUsersOfRoleSupplier getUsersOfRole;

    private final PasswordEncoder passwordEncoder;

    @Value("${default.role}")
    private String defaultRoleUser;

    @Value("${admin.role}")
    private String adminRoleUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUser.apply(username);
    }

    @Override
    public User registerUser(CreateUserRequest createUserRequest) {

        User user = mapper.createUserRequestToUser(createUserRequest);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(getRoleIfExists.apply(defaultRoleUser));


        createUser.accept(user);
        return user;
    }

    @Override
    public User registerAdmin(CreateUserRequest createUserRequest) {
        User user = mapper.createUserRequestToUser(createUserRequest);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(getRoleIfExists.apply(adminRoleUser));


        createUser.accept(user);
        return user;
    }

    @Override
    public List<UserResponse> getUsersOfRole(String role) {
        List<User> admins = getUsersOfRole.apply(role);

        return mapper.userListToUserResponseList(admins);
    }
}
