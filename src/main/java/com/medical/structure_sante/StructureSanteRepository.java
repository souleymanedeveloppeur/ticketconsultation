package com.medical.structure_sante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StructureSanteRepository extends JpaRepository<StructureSante, Long> {

    @Query("SELECT s FROM StructureSante s WHERE s.name LIKE %:name%")
    List<StructureSante> findByNameContainingIgnoreCase(String name);

    @Query("SELECT s FROM StructureSante s WHERE s.type = :type")
    List<StructureSante> findByType(TypeStructure type);
}