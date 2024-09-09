package com.trint.identity_service.mapper;

import com.trint.identity_service.dto.request.UserCreationRequest;
import com.trint.identity_service.dto.request.UserUpdateRequest;
import com.trint.identity_service.dto.response.UserResponse;
import com.trint.identity_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
    UserResponse toUserResponse(User user);
}
