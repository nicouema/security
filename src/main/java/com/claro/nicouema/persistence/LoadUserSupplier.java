package com.claro.nicouema.persistence;

import com.claro.nicouema.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class LoadUserSupplier implements Function<String, User> {

    private final UserMapper mapper;

    @Override
    public User apply(String s) {
        return mapper.getUserByUsername(s);
    }
}
