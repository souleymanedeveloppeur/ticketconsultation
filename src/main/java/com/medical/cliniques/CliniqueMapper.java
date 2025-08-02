package com.medical.cliniques;

import com.medical.dtos.CliniqueDto;


import java.util.List;

public interface CliniqueMapper {

    CliniqueEntity toEntity(CliniqueDto dto);
    CliniqueDto toDto(CliniqueEntity entity);
    List<CliniqueDto> toDto(List<CliniqueEntity> entities);
}
