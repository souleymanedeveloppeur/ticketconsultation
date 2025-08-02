package com.medical.cliniques;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliniques")
public class CliniqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private String libelle;
    private String adresse;
    private String telephone;
    private String email;
    private LocalDateTime dateInscription;
    @Column(columnDefinition = "boolean default true")
    private boolean actif;

    @PrePersist
    protected void onCreate() {
        dateInscription = LocalDateTime.now();
    }
}
