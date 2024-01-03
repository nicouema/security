package com.claro.nicouema.persistence;

import com.claro.nicouema.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class GetUsersOfRoleSupplier implements Function<String, List<User>> {

    private final UserMapper mapper;

    @Override
    public List<User> apply(String s) {
        return mapper.getUsersWithRole(s);
    }
}
