package com.medical.habilitations;

import com.medical.profils.ProfilEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actions")
public class ActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private String libelle;

    @ManyToMany(mappedBy = "actions")
    private Set<ProfilEntity> profils = new HashSet<>();
}
