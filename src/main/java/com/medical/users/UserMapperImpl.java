package com.medical.users;

import com.medical.dtos.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserEntity toEntity(UserDto dto) {
        return UserEntity.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .idClinique(dto.getIdClinique())
                .build();
    }

    @Override
    public UserDto toDto(UserEntity entity) {
        return UserDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .telephone(entity.getTelephone())
                .actif(entity.isActif())
                .idClinique(entity.getIdClinique())
                .build();
    }

    @Override
    public List<UserDto> toDto(List<UserEntity> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
