package com.medical.ticket;

import com.medical.dtos.TicketDto;
import com.medical.dtos.TicketResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequestMapping("/api/ticket")
@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    // Créer un ticket
    @PostMapping
    public ResponseEntity<TicketResponseDto> createTicket(@RequestBody TicketDto dto) {
        return ResponseEntity.ok(ticketService.createTicket(dto));
    }

    // Récupérer tous les tickets
    @GetMapping
    public ResponseEntity<List<TicketResponseDto>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    // Récupérer un ticket par ID
    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    // Mettre à jour un ticket
    @PutMapping("/{id}")
    public ResponseEntity<TicketResponseDto> updateTicket(@PathVariable Long id, @RequestBody TicketDto dto) {
        return ResponseEntity.ok(ticketService.updateTicket(id, dto));
    }

    // Supprimer un ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }

    // Mettre à jour le statut d'un ticket
    @PatchMapping("/{id}/status")
    public ResponseEntity<TicketResponseDto> updateTicketStatus(@PathVariable Long id, @RequestParam int status) {
        return ResponseEntity.ok(ticketService.updateTicketStatus(id, status));
    }

    // Récupérer les tickets par statut
    @GetMapping("/status/{status}")
    public ResponseEntity<List<TicketResponseDto>> getTicketsByStatus(@PathVariable int status) {
        return ResponseEntity.ok(ticketService.getTicketsByStatus(status));
    }

    // Récupérer les tickets par agent
    @GetMapping("/agent/{agentId}")
    public ResponseEntity<List<TicketResponseDto>> getTicketsByAgentId(@PathVariable Long agentId) {
        return ResponseEntity.ok(ticketService.getTicketsByAgentId(agentId));
    }

    // Compter les tickets par statut
    @GetMapping("/count/status/{status}")
    public ResponseEntity<Long> countTicketsByStatus(@PathVariable int status) {
        return ResponseEntity.ok(ticketService.countTicketsByStatus(status));
    }
}
