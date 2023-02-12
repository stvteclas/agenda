package com.stvteclas.agenda.repository;

import com.stvteclas.agenda.model.EmpresaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

    Page<EmpresaEntity> findByNombreContaining(String nombre, Pageable pageable);
}
