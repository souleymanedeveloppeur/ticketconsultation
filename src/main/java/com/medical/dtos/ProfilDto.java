package com.medical.dtos;


import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfilDto {
    private Long id;
    private String libelle;
    private boolean actif;
    private List<Long> actionIds;
}
