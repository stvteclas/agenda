package com.stvteclas.agenda.repository;

import com.stvteclas.agenda.model.ContactoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<ContactoEntity, Long> {

    Page<ContactoEntity> findByNombreContaining(String nombre, Pageable pageable);
}
