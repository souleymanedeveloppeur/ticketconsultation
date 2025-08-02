package com.medical.dtos;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CliniqueDto {
    private Long id;
    private String libelle;
    private String adresse;
    private String telephone;
    private String email;
    private LocalDateTime dateInscription;
    private boolean actif;
}
