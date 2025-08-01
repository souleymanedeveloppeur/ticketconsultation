package com.medical.ticket;

import com.medical.constantes.TicketConstant;
import com.medical.dtos.TicketDto;
import com.medical.dtos.TicketResponseDto;
import com.medical.users.UserEntity;
import com.medical.utils.TicketNumberGenerator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService{
    
    private final TicketRepository repository;
    private final TicketMapper mapper;

    private TicketEntity loadEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ticket non trouvé avec l'ID : " + id));
    }
    private UserEntity getUserConnect(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserEntity) authentication.getPrincipal();
    }

    @Override
    public TicketResponseDto createTicket(TicketDto ticketDto) {
        TicketEntity entity=mapper.toEntity(ticketDto);
        entity.setNumero(TicketNumberGenerator.generateTicketNumber());
        entity.setStatus(TicketConstant.SOUMISE);
        entity.setIdUser(getUserConnect().getId());
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public TicketResponseDto updateTicket(Long id, TicketDto ticketDto) {
        TicketEntity entity=loadEntityById(id);
        entity.setPrenomPatient(ticketDto.getPrenomPatient());
        entity.setNomPatient(ticketDto.getNomPatient());
        entity.setCategory(ticketDto.getCategory());
        entity.setSexe(ticketDto.getSexe());
        entity.setTypeConsultation(ticketDto.getTypeConsultation());
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteTicket(Long id) {

    }

    @Override
    public TicketResponseDto getTicketById(Long id) {
        return mapper.toDto(loadEntityById(id));
    }

    @Override
    public List<TicketResponseDto> getAllTickets() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<TicketResponseDto> getTicketsByStatus(int status) {
        return mapper.toDto(repository.findAllByStatus(status));
    }

    @Override
    public List<TicketResponseDto> getTicketsByAgentId(Long agentId) {
        return List.of();
    }

    @Override
    public TicketResponseDto updateTicketStatus(Long id, int newStatus) {
        TicketEntity entity=loadEntityById(id);
        entity.setStatus(newStatus);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public long countTicketsByStatus(int status) {
        return 0;
    }
}
