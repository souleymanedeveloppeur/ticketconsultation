package com.medical.ticket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numero; 
    private String prenomPatient;
    private String nomPatient;
    private LocalDateTime dateGeneration;
    @Column(columnDefinition = "int default 0")
    private int status;
    @Column(columnDefinition = "int default 0")
    private int category;
    @Column(columnDefinition = "int default 0")
    private int sexe;
    @Column(columnDefinition = "int default 0")
    private int typeConsultation;
    @Column(columnDefinition = "int default 0")
    private int priorite;

    private Long idUser;

    @Column(name = "clinique")
    private Long idClinique;

    @PrePersist
    protected void onCreate() {
        dateGeneration = LocalDateTime.now();
    }
}
