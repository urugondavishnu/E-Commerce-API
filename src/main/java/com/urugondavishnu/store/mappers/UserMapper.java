package com.urugondavishnu.store.mappers;

import com.urugondavishnu.store.dtos.RegisterUserRequest;
import com.urugondavishnu.store.dtos.UpdateUserRequest;
import com.urugondavishnu.store.dtos.UserDto;
import com.urugondavishnu.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request,@MappingTarget User user);
}
