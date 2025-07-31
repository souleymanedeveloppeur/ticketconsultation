package com.medical.users;

import com.medical.dtos.UserDto;

import java.util.List;

public interface UserMapper {
    UserEntity toEntity(UserDto dto);
    UserDto toDto(UserEntity entity);
    List<UserDto> toDto(List<UserEntity> entities);
}
