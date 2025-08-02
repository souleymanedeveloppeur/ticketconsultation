package com.medical.cliniques;

import com.medical.dtos.CliniqueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliniques")
@RequiredArgsConstructor
public class CliniqueController {


    private final CliniqueService cliniqueService;

    @PostMapping
    public ResponseEntity<CliniqueDto> createClinique(@RequestBody CliniqueDto dto) {
        try {
            CliniqueDto created = cliniqueService.createClinique(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CliniqueDto> updateClinique(@PathVariable Long id, @RequestBody CliniqueDto dto) {
        try {
            CliniqueDto updated = cliniqueService.updateClinique(id, dto);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CliniqueDto> getCliniqueById(@PathVariable Long id) {
        CliniqueDto dto = cliniqueService.getCliniqueById(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CliniqueDto>> getAllCliniques() {
        List<CliniqueDto> cliniques = cliniqueService.getAllCliniques();
        return ResponseEntity.ok(cliniques);
    }
}
