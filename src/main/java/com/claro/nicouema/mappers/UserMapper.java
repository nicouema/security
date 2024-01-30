package com.claro.nicouema.mappers;

import com.claro.nicouema.model.User;
import com.claro.nicouema.requests.CreateUserRequest;
import com.claro.nicouema.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {

    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "isActive", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "role", ignore = true)
    User createUserRequestToUser(CreateUserRequest user);

    UserResponse userToUserResponse(User user);

    List<UserResponse> userListToUserResponseList(List<User> admins);
}
