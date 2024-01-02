package com.claro.security.persistence;


import com.claro.security.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select(value = "SELECT * " +
            "FROM users u, role r " +
            "WHERE username=#{username} " +
            "AND u.role=r.id")
    @Result(column = "id", property = "role.id")
    @Result(column = "description", property = "role.description")
    User getUserByUsername(String username);

    @Insert(value = "INSERT INTO users " +
            "(username, email, password, role) " +
            "VALUES " +
            "(#{username}, #{email}, #{password}, #{role.id})")
    void createNewUser(User user);

    @Select(value = "SELECT * " +
            "FROM users u " +
            "WHERE u.role=#{role}")
    List<User> getUsersWithRole(String role);

}
