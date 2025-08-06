package com.medical.structure_sante;

import com.medical.model.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static com.medical.utils.ApiUtil.createSuccessResponse;

@Service
@Slf4j
@RequiredArgsConstructor
public class StructureSanteServiceImpl implements StructureSanteService {

    private final StructureSanteRepository repository;
    private final StructureSanteMapper mapper;
    private final StructureSanteRepository structureSanteRepository;


    @Override
    public ApiResponse<StructureSanteDto> create(StructureSanteRequestDto structureSanteDto) {
        StructureSante structureSante = mapper.toEntity(structureSanteDto);
        structureSante.setDateInscription(Instant.now());
        structureSante.setLogoUrl("https://example.com/logo.png"); // Placeholder for logo URL

        StructureSante savedStructure = repository.save(structureSante);
        log.info("Structure de santé créée avec succès : {}", savedStructure.getId());

        return createSuccessResponse("Structure de santé créée avec succès", mapper.toDto(savedStructure));
    }

    @Override
    public ApiResponse<StructureSanteDto> update(Long id, StructureSanteDto structureSanteDto) {
        return null;
    }

    @Override
    public ApiResponse<StructureSanteDto> findById(Long id) {
        StructureSanteDto structureSanteDto = structureSanteRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Structure de santé avec ID " + id + " introuvable"));
        return createSuccessResponse("Structure de santé trouvée", structureSanteDto);
    }

    @Override
    public ApiResponse<List<StructureSanteDto>> findAll() {
        List<StructureSanteDto> structureSanteDtos = structureSanteRepository.findAll().stream()
                .map(mapper::toDto)
                .toList();
        return createSuccessResponse("Liste des structures de santé", structureSanteDtos);
    }

    @Override
    public ApiResponse<List<StructureSanteDto>> searchByName(String name) {
        List<StructureSanteDto> structureSanteDtos = structureSanteRepository.findByNameContainingIgnoreCase(name).stream()
                .map(mapper::toDto)
                .toList();
        return createSuccessResponse("Recherche de structures de santé par nom", structureSanteDtos);
    }

    @Override
    public ApiResponse<List<StructureSanteDto>> findByType(@NotNull TypeStructure type) {
        List<StructureSanteDto> structureSanteDtos = structureSanteRepository.findByType(type).stream()
                .map(mapper::toDto)
                .toList();
        return createSuccessResponse("Structures de santé trouvées par type", structureSanteDtos);
    }
}
