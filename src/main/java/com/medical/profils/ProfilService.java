package com.medical.profils;

import com.medical.dtos.ProfilDto;

import java.util.List;

public interface ProfilService {
    ProfilDto createProfil(ProfilDto dto) throws Exception;
    ProfilDto updateProfil(Long id, ProfilDto dto) throws Exception;
    ProfilDto getProfilById(Long id);
    List<ProfilDto> getAllProfils();

}
