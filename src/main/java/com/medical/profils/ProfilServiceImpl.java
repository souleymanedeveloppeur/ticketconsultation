package com.medical.profils;

import com.medical.dtos.ProfilDto;
import com.medical.habilitations.ActionEntity;
import com.medical.habilitations.ActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProfilServiceImpl implements ProfilService{

    private final ProfilRepository repository;
    private final ProfilMapper mapper;
    private final ActionRepository actionRepository;
    private ProfilEntity loadEntityById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profil non trouvé avec l'id: " + id));
    }

    private void validationProfil(ProfilDto dto) throws Exception {
        if(dto == null)
            throw new Exception("L'objet à enregistrer est null");
        if(dto.getLibelle() == null)
            throw new Exception("Le libellé est obligatoire");
        if(dto.getActionIds() == null || dto.getActionIds().isEmpty())
            throw new Exception("Au moins une action est obligatoire");
        ProfilEntity model = repository.findByLibelle(dto.getLibelle());
        if (dto.getId() == null && model != null || model != null && !model.getId().equals(dto.getId()))
            throw new Exception("Ce libellé est déjà utilisé");
    }

    @Override
    public ProfilDto createProfil(ProfilDto dto) throws Exception {
        validationProfil(dto);
        ProfilEntity entity =mapper.toEntity(dto);
        List<ActionEntity> actionEntities=actionRepository.findAllById(dto.getActionIds());
        entity.setActions(new HashSet<>(actionEntities) );
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public ProfilDto updateProfil(Long id, ProfilDto dto) throws Exception {
        validationProfil(dto);
       ProfilEntity entity= loadEntityById(id);
       entity.setLibelle(dto.getLibelle());
        List<ActionEntity> actionEntities=actionRepository.findAllById(dto.getActionIds());
        entity.setActions(new HashSet<>(actionEntities) );
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public ProfilDto getProfilById(Long id) {
        return mapper.toDto(loadEntityById(id));
    }

    @Override
    public List<ProfilDto> getAllProfils() {
        return mapper.toDto(repository.findAll());
    }
}
