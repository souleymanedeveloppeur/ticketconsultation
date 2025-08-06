package com.medical.service;

import com.medical.structure_sante.StructureSanteDto;
import com.medical.structure_sante.StructureSanteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ServiceSanteMapper {

    private final StructureSanteMapper structureSanteMapper;


    public ServiceSante toEntity(ServiceSanteRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        ServiceSante serviceSante = new ServiceSante();
        serviceSante.setName(requestDto.name());
        serviceSante.setType(requestDto.type());
        return serviceSante;
    }

    public ServiceSanteDto toDto(ServiceSante save) {
        if (save == null) {
            return null;
        }
        return new ServiceSanteDto(
                save.getId(),
                save.getCodeService(),
                save.getName(),
                save.getType(),
                save.isActive(),
                save.getStructureSante() != null ? structureSanteMapper.toDto(save.getStructureSante()) : null
        );
    }

    public void updateEntityFromDto(ServiceSanteRequestDto requestDto, ServiceSante serviceSante) {
        if (requestDto == null || serviceSante == null) {
            return;
        }
        serviceSante.setName(requestDto.name());
        serviceSante.setType(requestDto.type());
    }
}
