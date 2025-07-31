package com.medical.dtos;
import lombok.*;
import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponseDto {
    private Long id;
    private String numero; // ex: "TCK-20250729-0001"
    private String prenomPatient;
    private String nomPatient;
    private LocalDateTime dateGeneration;
    private String status;
    private String category;
    private String sexe;
    private String typeConsultation;
}
