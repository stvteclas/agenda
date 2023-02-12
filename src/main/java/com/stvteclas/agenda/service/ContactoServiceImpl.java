package com.stvteclas.agenda.service;

import com.stvteclas.agenda.model.ContactoEntity;
import com.stvteclas.agenda.repository.ContactoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContactoServiceImpl implements ContactoService {

    private final ContactoRepository contactoRepository;


    @Override
    public Page<ContactoEntity> findAll(Pageable pageable) {
        Page<ContactoEntity> contactoPage = contactoRepository.findAll(pageable);

        return contactoPage;
    }

    @Override
    public void save(ContactoEntity contacto) {
        contacto.setFechaRegistro(LocalDateTime.now());
        contactoRepository.save(contacto);
    }

    @Override
    public ContactoEntity getById(Long id) {
        return contactoRepository.getReferenceById(id);
    }

    @Override
    public void update(ContactoEntity contacto) {
        contactoRepository.save(contacto);
    }

    @Override
    public void delete(ContactoEntity contactoFromDB) {
        contactoRepository.delete(contactoFromDB);
    }

    @Override
    public Page<ContactoEntity> findByNombreContaining(String busqueda, Pageable pageable) {
        return contactoRepository.findByNombreContaining(busqueda,pageable);
    }
}
