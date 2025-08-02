package com.medical.cliniques;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CliniqueRepository extends JpaRepository<CliniqueEntity,Long> {
    CliniqueEntity findByLibelle(String libelle);
}
