package com.claro.nicouema.persistence;

import com.claro.nicouema.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class GetRoleByIdSupplier implements Function<String, Role> {

    private final RoleMapper roleMapper;

    @Override
    public Role apply(String s) {
        return roleMapper.getRoleById(s);
    }
}
