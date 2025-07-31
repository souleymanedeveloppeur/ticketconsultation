package com.medical.ticket;

import com.medical.dtos.TicketDto;
import com.medical.dtos.TicketResponseDto;

import java.util.List;
public interface TicketService {
    // Créer un nouveau ticket
    TicketResponseDto createTicket(TicketDto ticketDto);

    // Mettre à jour un ticket existant
    TicketResponseDto updateTicket(Long id, TicketDto ticketDto);

    // Supprimer un ticket par ID
    void deleteTicket(Long id);

    // Récupérer un ticket par ID
    TicketResponseDto getTicketById(Long id);

    // Récupérer la liste de tous les tickets
    List<TicketResponseDto> getAllTickets();

    // Récupérer les tickets selon le statut
    List<TicketResponseDto> getTicketsByStatus(int status);

    // Récupérer les tickets d'un agent spécifique
    List<TicketResponseDto> getTicketsByAgentId(Long agentId);

    // Mettre à jour le statut d'un ticket
    TicketResponseDto updateTicketStatus(Long id, int newStatus);

    // Compter les tickets par statut
    long countTicketsByStatus(int status);

    // Vérifier l’existence d’un ticket
   // boolean existsById(Long id);
}
