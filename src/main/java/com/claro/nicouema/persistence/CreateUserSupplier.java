package com.claro.nicouema.persistence;

import com.claro.nicouema.exception.ConflictException;
import com.claro.nicouema.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class CreateUserSupplier implements Consumer<User> {

    private final UserMapper mapper;

    @Override
    public void accept(User user) {
        try {
            mapper.createNewUser(user);
        } catch (DuplicateKeyException e) {
            throw new ConflictException("User: " + user.getUsername() + " already exists");
        }

    }
}
