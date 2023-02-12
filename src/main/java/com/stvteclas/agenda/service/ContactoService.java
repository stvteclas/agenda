package com.stvteclas.agenda.service;

import com.stvteclas.agenda.model.ContactoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ContactoService{
    Page<ContactoEntity> findAll(Pageable pageable);

    void save(ContactoEntity contacto);

    ContactoEntity getById(Long id);

    void update(ContactoEntity contacto);

    void delete(ContactoEntity contactoFromDB);

    Page<ContactoEntity> findByNombreContaining(String busqueda, Pageable pageable);
}
