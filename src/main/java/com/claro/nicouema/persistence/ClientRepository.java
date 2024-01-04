package com.claro.nicouema.persistence;

import com.claro.nicouema.model.Client;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClientRepository {

    @Insert(value = "INSERT INTO client (name, lastname, birthdate, username) " +
            "VALUES (#{name}, #{lastname}, #{birthdate}, #{username})")
//    @Result(column = "client_id", property = "id")
//    @Result(column = "username", property = "user.username")
    long saveClient(Client client);

    @Select(value = "SELECT * FROM client c, user u " +
            "WHERE c.username=u.username " +
            "AND client_id=#{id}")
    @Result(column = "username", property = "user.username")
    @Result(column = "password", property = "user.password")
    Client getClientById(Long id);
}
