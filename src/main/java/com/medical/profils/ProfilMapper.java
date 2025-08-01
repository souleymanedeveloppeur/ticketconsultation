package com.medical.profils;

import com.medical.dtos.ProfilDto;

import java.util.List;

public interface ProfilMapper {
    ProfilEntity toEntity(ProfilDto dto);
    ProfilDto toDto(ProfilEntity entity);
    List<ProfilDto> toDto(List<ProfilEntity> entities);
}
