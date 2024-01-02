package com.claro.security.persistence;

import com.claro.security.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {

    @Select(value = "SELECT * " +
            "FROM role " +
            "WHERE id=#{idRoel}")
    Role getRoleById(String idRole);
}
