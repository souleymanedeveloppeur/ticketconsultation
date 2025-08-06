package com.medical.service;

import com.medical.model.ApiResponse;
import com.medical.structure_sante.StructureSante;
import com.medical.structure_sante.StructureSanteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.medical.utils.ApiUtil.createSuccessResponse;


@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceSanteServiceImpl implements ServiceSanteService {

    private final ServiceSanteRepository serviceSanteRepository;
    private final ServiceSanteMapper serviceSanteMapper;
    private final StructureSanteRepository structureSanteRepository;

    @Override
    public ApiResponse<ServiceSanteDto> create(ServiceSanteRequestDto requestDto) {
        ServiceSante serviceSante = serviceSanteMapper.toEntity(requestDto);

        if (requestDto.structureID() != null) {
            StructureSante structureSante = structureSanteRepository.findById(requestDto.structureID()).orElseThrow(() -> new RuntimeException("La structure n'existe pas"));
            serviceSante.setStructureSante(structureSante);
        }

        return createSuccessResponse("Service de santé créé avec succès",
                serviceSanteMapper.toDto(serviceSanteRepository.save(serviceSante)));
    }

    @Override
    public ApiResponse<ServiceSanteDto> update(Long id, ServiceSanteRequestDto requestDto) {
        ServiceSante serviceSante = serviceSanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service de santé introuvable"));

        serviceSanteMapper.updateEntityFromDto(requestDto, serviceSante);

        if (requestDto.structureID() != null) {
            StructureSante structureSante = structureSanteRepository.findById(requestDto.structureID())
                    .orElseThrow(() -> new RuntimeException("La structure n'existe pas"));
            serviceSante.setStructureSante(structureSante);
        }

        return createSuccessResponse("Service de santé mis à jour avec succès",
                serviceSanteMapper.toDto(serviceSanteRepository.save(serviceSante)));
    }

    @Override
    public ApiResponse<ServiceSanteDto> getById(Long id) {
        ServiceSanteDto santeDto = serviceSanteRepository.findById(id)
                .map(serviceSanteMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Service de santé introuvable"));
        return createSuccessResponse("Service de santé trouvé", santeDto);
    }

    @Override
    public ApiResponse<List<ServiceSanteDto>> getAll() {
        List<ServiceSanteDto> serviceSanteDtos = serviceSanteRepository.findAll().stream()
                .map(serviceSanteMapper::toDto)
                .toList();
        return createSuccessResponse("Liste des services de santé", serviceSanteDtos);
    }


    @Override
    public ApiResponse<ServiceSanteDto> toggleActive(Long id) {
        ServiceSante serviceSante = serviceSanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service de santé introuvable"));
        serviceSante.setActive(!serviceSante.isActive());
        ServiceSante savedService = serviceSanteRepository.save(serviceSante);
        return createSuccessResponse("Service de santé mis à jour avec succès", serviceSanteMapper.toDto(savedService));
    }
}
