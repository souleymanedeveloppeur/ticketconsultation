package com.medical.service;

import com.medical.model.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services-sante")
@RequiredArgsConstructor
public class ServiceSanteController {

    private final ServiceSanteService serviceSanteService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ServiceSanteDto>>> getAllServices() {
        return ResponseEntity.ok(serviceSanteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ServiceSanteDto>> getServiceById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(serviceSanteService.getById(id));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ServiceSanteDto>> createService(@RequestBody ServiceSanteRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceSanteService.create(requestDto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ServiceSanteDto>> updateService(@PathVariable("id") Long id, @RequestBody ServiceSanteRequestDto requestDto) {
        return ResponseEntity.ok(serviceSanteService.update(id, requestDto));
    }

    @PutMapping("/{id}/toggle-active")
    public ResponseEntity<ApiResponse<ServiceSanteDto>> toggleServiceActive(@PathVariable("id") Long id) {
        return ResponseEntity.ok(serviceSanteService.toggleActive(id));
    }
}
