package com.claro.security.mappers;

import com.claro.security.model.User;
import com.claro.security.requests.CreateUserRequest;
import com.claro.security.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserDTOsMapper {

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "lastname", ignore = true)
    @Mapping(target = "birthdate", ignore = true)
    User createUserRequestToUser(CreateUserRequest user);

    UserResponse userToUserResponse(User user);

    List<UserResponse> userListToUserResponseList(List<User> admins);
}
