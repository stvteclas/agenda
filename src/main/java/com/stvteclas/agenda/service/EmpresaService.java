package com.stvteclas.agenda.service;

import com.stvteclas.agenda.model.EmpresaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EmpresaService{
    Page<EmpresaEntity> findAll(Pageable pageable);

    void save(EmpresaEntity empresa);

    EmpresaEntity getById(Long id);

    void update(EmpresaEntity empresa);

    void delete(EmpresaEntity empresaFromDB);

    Page<EmpresaEntity> findByNombreContaining(String busqueda, Pageable pageable);
}
