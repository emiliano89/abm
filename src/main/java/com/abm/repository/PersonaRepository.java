package com.abm.repository;

import com.abm.model.Persona;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.abm.repository.QueryConstants.FIND_BY_DOCUMENT_TYPE;
import static com.abm.repository.QueryConstants.FIND_BY_NAME;

@Repository
@Transactional
@ComponentScan("com.abm")
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query(value = FIND_BY_NAME, nativeQuery = true)
    List<Persona> findByPerNombre(String perNombre);

    @Query(value = FIND_BY_DOCUMENT_TYPE, nativeQuery = true)
    List<Persona> findByPerTipoDocumento(String perTipoDocumento);
}
