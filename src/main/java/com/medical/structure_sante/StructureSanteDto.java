package com.medical.structure_sante;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link StructureSante}
 */
@Builder
public record StructureSanteDto(Long id, String name, String address, TypeStructure type, String logoUrl, LocalDateTime dateInscription) implements Serializable {
  }