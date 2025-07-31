package com.medical.ticket;



import com.medical.dtos.TicketDto;
import com.medical.dtos.TicketResponseDto;

import java.util.List;

public interface TicketMapper {
    TicketEntity toEntity(TicketDto dto);
    TicketResponseDto toDto(TicketEntity entity);
    List<TicketResponseDto> toDto(List<TicketEntity> entities);
}
