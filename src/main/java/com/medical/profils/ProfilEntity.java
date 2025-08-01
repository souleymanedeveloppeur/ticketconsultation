package com.medical.profils;

import com.medical.habilitations.ActionEntity;
import com.medical.users.UserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profil")
public class ProfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private String libelle;
    @Column(columnDefinition = "boolean default true")
    private boolean actif;

    @OneToMany(mappedBy = "profil")
    private List<UserEntity> users;

    @ManyToMany
    @JoinTable(
            name = "profil_action", // nom de la table d'association
            joinColumns = @JoinColumn(name = "profil_id"), // clé étrangère vers Profil
            inverseJoinColumns = @JoinColumn(name = "action_id") // clé étrangère vers Action
    )
    private Set<ActionEntity> actions = new HashSet<>();
}
