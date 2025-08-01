package com.medical.habilitations;

import com.medical.dtos.ActionDto;



import java.util.List;

public interface ActionMapper {

    ActionEntity toEntity(ActionDto dto);
    ActionDto toDto(ActionEntity entity);
    List<ActionDto> toDto(List<ActionEntity> entities);
}
