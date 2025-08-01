package com.medical.habilitations;

import com.medical.dtos.ActionDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ActionMapperImpl implements ActionMapper {
    @Override
    public ActionEntity toEntity(ActionDto dto) {
        return ActionEntity.builder()
                .libelle(dto.getLibelle())
                .build();
    }

    @Override
    public ActionDto toDto(ActionEntity entity) {
        return ActionDto.builder()
                .id(entity.getId())
                .libelle(entity.getLibelle())
                .build();
    }

    @Override
    public List<ActionDto> toDto(List<ActionEntity> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
