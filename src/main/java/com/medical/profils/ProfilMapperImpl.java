package com.medical.profils;

import com.medical.dtos.ProfilDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfilMapperImpl implements ProfilMapper {
    @Override
    public ProfilEntity toEntity(ProfilDto dto) {
        return ProfilEntity.builder()
                .libelle(dto.getLibelle())
                .build();
    }

    @Override
    public ProfilDto toDto(ProfilEntity entity) {
        return ProfilDto.builder()
                .id(entity.getId())
                .actif(entity.isActif())
                .libelle(entity.getLibelle())
                .build();
    }

    @Override
    public List<ProfilDto> toDto(List<ProfilEntity> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
