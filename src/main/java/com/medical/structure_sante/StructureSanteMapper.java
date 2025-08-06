package com.medical.structure_sante;

import org.springframework.stereotype.Service;

@Service
public class StructureSanteMapper {


    public StructureSante toEntity(StructureSanteRequestDto structureSanteDto) {
        return StructureSante.builder()
                .name(structureSanteDto.name())
                .address(structureSanteDto.address())
                .type(structureSanteDto.type())
                .build();
    }

    public StructureSanteDto toDto(StructureSante savedStructure) {
        return StructureSanteDto.builder()
                .id(savedStructure.getId())
                .name(savedStructure.getName())
                .address(savedStructure.getAddress())
                .type(savedStructure.getType())
                .logoUrl(savedStructure.getLogoUrl())
                .dateInscription(savedStructure.getDateInscription())
                .build();
    }
}
