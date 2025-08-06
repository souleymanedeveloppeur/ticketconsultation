package com.medical.service;

import com.medical.structure_sante.StructureSanteDto;

import java.io.Serializable;

/**
 * DTO for {@link ServiceSante}
 */
public record ServiceSanteDto(Long id, String codeService, String name, TypeService type, boolean active,
                              StructureSanteDto structureSante) implements Serializable {
}