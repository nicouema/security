package com.claro.nicouema.service.impl;

import com.claro.nicouema.mappers.UserDTOsMapper;
import com.claro.nicouema.model.Role;
import com.claro.nicouema.model.User;
import com.claro.nicouema.persistence.CreateUserSupplier;
import com.claro.nicouema.persistence.GetUsersOfRoleSupplier;
import com.claro.nicouema.persistence.LoadUserSupplier;
import com.claro.nicouema.requests.CreateUserRequest;
import com.claro.nicouema.response.UserResponse;
import com.claro.nicouema.service.UserService;
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
