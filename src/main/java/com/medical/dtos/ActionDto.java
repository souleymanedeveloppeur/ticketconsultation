package com.medical.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionDto {
    private Long id;
    private String libelle;
}
