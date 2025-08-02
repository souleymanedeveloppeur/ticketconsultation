package com.medical.profils;

import com.medical.dtos.ProfilDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profils")
@RequiredArgsConstructor
public class ProfilController {
    private final ProfilService profilService;


    @PostMapping
    public ResponseEntity<ProfilDto> createProfil(@RequestBody ProfilDto dto) {
        try {
            ProfilDto created = profilService.createProfil(dto);
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfilDto> updateProfil(@PathVariable Long id, @RequestBody ProfilDto dto) {
        try {
            ProfilDto updated = profilService.updateProfil(id, dto);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfilDto> getProfilById(@PathVariable Long id) {
        ProfilDto profil = profilService.getProfilById(id);
        if (profil != null) {
            return ResponseEntity.ok(profil);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ProfilDto>> getAllProfils() {
        List<ProfilDto> profils = profilService.getAllProfils();
        return ResponseEntity.ok(profils);
    }
}
