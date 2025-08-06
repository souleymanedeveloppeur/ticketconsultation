package com.medical.structure_sante;

import com.medical.model.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/structure-sante")
@RequiredArgsConstructor
public class StructureSanteController {

    private final StructureSanteService structureSanteService;

     @GetMapping
     public ResponseEntity<ApiResponse<List<StructureSanteDto>>> getAllStructures() {
         return ResponseEntity.ok(structureSanteService.findAll());
     }

    @PostMapping
    public ResponseEntity<ApiResponse<StructureSanteDto>> createStructure(StructureSanteRequestDto structureSanteDto) {
        return ResponseEntity.ok(structureSanteService.create(structureSanteDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StructureSanteDto>> getStructureById(@PathVariable Long id) {
        return ResponseEntity.ok(structureSanteService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StructureSanteDto>> updateStructure(@PathVariable Long id, @RequestBody StructureSanteDto structureSanteDto) {
        return ResponseEntity.ok(structureSanteService.update(id, structureSanteDto));
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<StructureSanteDto>>> searchStructuresByName(@RequestParam String name) {
        return ResponseEntity.ok(structureSanteService.searchByName(name));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<ApiResponse<List<StructureSanteDto>>> getStructuresByType(@PathVariable TypeStructure type) {
        return ResponseEntity.ok(structureSanteService.findByType(type));
    }



}
