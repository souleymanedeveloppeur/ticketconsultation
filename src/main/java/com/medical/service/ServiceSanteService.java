package com.medical.service;

import com.medical.model.ApiResponse;

import java.util.List;

public interface ServiceSanteService {

    ApiResponse<ServiceSanteDto> create(ServiceSanteRequestDto requestDto);

    ApiResponse<ServiceSanteDto> update(Long id, ServiceSanteRequestDto requestDto);

    ApiResponse<ServiceSanteDto> getById(Long id);

    ApiResponse<List<ServiceSanteDto>> getAll();

    ApiResponse<ServiceSanteDto> toggleActive(Long id);

}
