package com.medical.cliniques;

import com.medical.dtos.CliniqueDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CliniqueMapperImpl implements CliniqueMapper{
    @Override
    public CliniqueEntity toEntity(CliniqueDto dto) {
        return CliniqueEntity.builder()
                .libelle(dto.getLibelle())
                .email(dto.getEmail())
                .telephone(dto.getTelephone())
                .adresse(dto.getAdresse())
                .build();
    }

    @Override
    public CliniqueDto toDto(CliniqueEntity entity) {
        return CliniqueDto.builder()
                .id(entity.getId())
                .libelle(entity.getLibelle())
                .email(entity.getEmail())
                .telephone(entity.getTelephone())
                .dateInscription(entity.getDateInscription())
                .adresse(entity.getAdresse())
                .actif(entity.isActif())
                .build();
    }

    @Override
    public List<CliniqueDto> toDto(List<CliniqueEntity> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
