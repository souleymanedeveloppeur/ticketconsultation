package com.medical.service;

import com.medical.structure_sante.StructureSante;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "SERVICE_SANTE")
public class ServiceSante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CODE_SERVICE")
    private String codeService;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private TypeService type;

    @Column(name = "ACTIF")
    private boolean active;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STRUCTURE_SANTE_ID", referencedColumnName = "ID")
    private StructureSante structureSante;

}