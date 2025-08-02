package com.medical.cliniques;

import com.medical.dtos.CliniqueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CliniqueServiceImpl implements CliniqueService{
    private final CliniqueRepository repository;
    private final CliniqueMapper mapper;

    private CliniqueEntity loadEntityById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clinique non trouvé avec l'id: " + id));
    }

    private void validationClinique(CliniqueDto dto) throws Exception {
        if (dto == null)
            throw new Exception("L'objet Clinique est null");

        if (dto.getLibelle() == null || dto.getLibelle().trim().isEmpty())
            throw new Exception("Le nom de la clinique est obligatoire");

        if (dto.getAdresse() == null || dto.getAdresse().trim().isEmpty())
            throw new Exception("L'adresse de la clinique est obligatoire");

        if (dto.getEmail() == null || dto.getEmail().trim().isEmpty())
            throw new Exception("L'email de la clinique est obligatoire");

        CliniqueEntity model = repository.findByLibelle(dto.getLibelle());
        if (dto.getId() == null && model != null || model != null && !model.getId().equals(dto.getId()))
            throw new Exception("Une clinique avec ce nom existe déjà");
    }


    @Override
    public CliniqueDto createClinique(CliniqueDto dto) throws Exception {
        validationClinique(dto);
        CliniqueEntity entity=mapper.toEntity(dto);
        entity.setActif(true);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public CliniqueDto updateClinique(Long id, CliniqueDto dto) throws Exception {
        validationClinique(dto);
       CliniqueEntity entity= loadEntityById(id);
        entity.setLibelle(dto.getLibelle());
        entity.setAdresse(dto.getAdresse());
        entity.setEmail(dto.getEmail());
        entity.setTelephone(dto.getTelephone());
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public CliniqueDto getCliniqueById(Long id) {
        CliniqueEntity entity=loadEntityById(id);
        return mapper.toDto(entity);
    }

    @Override
    public List<CliniqueDto> getAllCliniques() {
        return mapper.toDto(repository.findAll());
    }
}
