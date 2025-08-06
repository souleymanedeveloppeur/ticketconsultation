package com.medical.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceSanteRepository extends JpaRepository<ServiceSante, Long> {
}