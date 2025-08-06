package com.medical.structure_sante;

import com.medical.service.TypeService;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "STRUCTURE_SANTE")
public class StructureSante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private TypeStructure type;

    @Column(name = "LOGO_URL")
    private String logoUrl;

    @Column(name = "DATE_INSCRIPTION")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Instant dateInscription;


}
