package com.claro.nicouema.persistence;


import com.claro.nicouema.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRepository {

    @Select(value = "SELECT * " +
            "FROM user u, role r " +
            "WHERE username=#{username} " +
            "AND u.role=r.id")
    @Result(column = "id", property = "role.id")
    @Result(column = "description", property = "role.description")
    User getUserByUsername(String username);

    @Insert(value = "INSERT INTO user " +
            "(username, email, password, role, created_at, is_active) " +
            "VALUES " +
            "(#{username}, #{email}, #{password}, #{role.id}, CURRENT_TIMESTAMP, 1)")
    void createNewUser(User user);

    @Select(value = "SELECT * " +
            "FROM user u " +
            "WHERE u.role=#{role}")
    List<User> getUsersWithRole(String role);

}
