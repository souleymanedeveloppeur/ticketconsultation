package com.medical.ticket;

import com.medical.constantes.ConstantesUtils;
import com.medical.dtos.TicketDto;
import com.medical.dtos.TicketResponseDto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketMapperImpl implements TicketMapper {
    @Override
    public TicketEntity toEntity(TicketDto dto) {
        return TicketEntity.builder()
        .prenomPatient(dto.getPrenomPatient())
        .nomPatient(dto.getNomPatient())
        .category(dto.getCategory())
        .sexe(dto.getSexe())
        .typeConsultation(dto.getTypeConsultation())
        .build();
    }

    @Override
    public TicketResponseDto toDto(TicketEntity entity) {
        return TicketResponseDto.builder()
        .id(entity.getId())
        .prenomPatient(entity.getPrenomPatient())
        .nomPatient(entity.getNomPatient())
        .numero(entity.getNumero())
        .sexe(ConstantesUtils.getSexeLabel(entity.getSexe()))
        .category(ConstantesUtils.getCategorieLabel(entity.getCategory()))
        .typeConsultation(ConstantesUtils.getTypeConsultationLabel(entity.getTypeConsultation()))
        .status(ConstantesUtils.getStatutTicketLabel(entity.getStatus()))
        .dateGeneration(entity.getDateGeneration())
        .build();
    }

    @Override
    public List<TicketResponseDto> toDto(List<TicketEntity> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
