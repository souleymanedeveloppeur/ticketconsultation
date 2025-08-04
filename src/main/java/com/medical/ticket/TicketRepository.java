package com.medical.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity,Long>{
    List<TicketEntity> findAllByStatus(int status);

    List<TicketEntity> findAllByIdClinique(Long id);

    @Query("SELECT t FROM TicketEntity t WHERE t.idClinique = :idClinique AND FUNCTION('DATE', t.dateGeneration) = CURRENT_DATE")
    List<TicketEntity> findAllByIdCliniqueAndToday(@Param("idClinique") Long idClinique);


}
