package com.medical.structure_sante;

import java.io.Serializable;

/**
 * DTO for {@link StructureSante}
 */
public record StructureSanteRequestDto(String name, String address, TypeStructure type) implements Serializable {
}