package com.medical.structure_sante;

import com.medical.model.ApiResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StructureSanteService {

    ApiResponse<StructureSanteDto> create(StructureSanteRequestDto structureSanteDto);

    ApiResponse<StructureSanteDto> update(Long id, StructureSanteDto structureSanteDto);

    ApiResponse<StructureSanteDto> findById(Long id);

    ApiResponse<List<StructureSanteDto>> findAll();

    ApiResponse<List<StructureSanteDto>> searchByName(String name);

    ApiResponse<List<StructureSanteDto>> findByType(TypeStructure type);
}
