package com.medical.cliniques;

import com.medical.dtos.CliniqueDto;

import java.util.List;

public interface CliniqueService {
    CliniqueDto createClinique(CliniqueDto dto) throws Exception;
    CliniqueDto updateClinique(Long id, CliniqueDto dto) throws Exception;
    CliniqueDto getCliniqueById(Long id);
    List<CliniqueDto> getAllCliniques();
}
