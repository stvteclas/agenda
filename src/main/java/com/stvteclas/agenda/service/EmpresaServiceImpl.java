package com.stvteclas.agenda.service;

import com.stvteclas.agenda.model.EmpresaEntity;
import com.stvteclas.agenda.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;


    @Override
    public Page<EmpresaEntity> findAll(Pageable pageable) {
        Page<EmpresaEntity> empresaPage = empresaRepository.findAll(pageable);

        return empresaPage;
    }

    @Override
    public void save(EmpresaEntity empresa) {
        empresa.setFechaRegistro(LocalDateTime.now());
        empresaRepository.save(empresa);
    }

    @Override
    public EmpresaEntity getById(Long id) {
        return empresaRepository.getReferenceById(id);
    }

    @Override
    public void update(EmpresaEntity empresa) {
        empresaRepository.save(empresa);
    }

    @Override
    public void delete(EmpresaEntity empresaFromDB) {
        empresaRepository.delete(empresaFromDB);
    }

    @Override
    public Page<EmpresaEntity> findByNombreContaining(String busqueda, Pageable pageable) {
        return empresaRepository.findByNombreContaining(busqueda,pageable);
    }
}
