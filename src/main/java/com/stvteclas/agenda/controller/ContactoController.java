package com.stvteclas.agenda.controller;

import com.stvteclas.agenda.dto.ContactoRequestDTO;
import com.stvteclas.agenda.model.ContactoEntity;
import com.stvteclas.agenda.service.ContactoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping
public class ContactoController {

    @Autowired
    ContactoService contactoService;

    @GetMapping("/index")
    String index(Pageable pageable, @RequestParam(required = false) String busqueda, Model model) {
        Page<ContactoEntity> contactoPage ;
        if (busqueda !=null && busqueda.trim().length()> 0){
            contactoPage = contactoService.findByNombreContaining(busqueda, pageable);
        }else {
            contactoPage = contactoService.findAll(pageable);
        }

        model.addAttribute("contactoPage", contactoPage);
        return "index";
    }

    @GetMapping("/nuevo")
    String nuevo(Model model) {
        model.addAttribute("contacto", new ContactoEntity());
        return "nuevo";
    }

    @PostMapping("/nuevo")
    String crear(@Validated ContactoEntity contacto, BindingResult bindingResult, RedirectAttributes ra, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contacto", contacto);
            return "nuevo";
        }
        contactoService.save(contacto);
        ra.addFlashAttribute("msgExito", "El contacto se ha creado correctamente");
        return "redirect:/index";
    }

    @GetMapping("/{id}/editar")
    String editar(@PathVariable Long id, Model model) {
        ContactoEntity contacto = contactoService.getById(id);
        model.addAttribute("contacto", contacto);
        return "editar";
    }

    @PostMapping("/{id}/editar")
    String actualizar(
            @PathVariable Long id,
            @Validated ContactoEntity contacto,
            BindingResult bindingResult,
            RedirectAttributes ra,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("contacto", contacto);
            return "editar";
        }
        ContactoEntity contactoFromDB = contactoService.getById(id);
        contactoFromDB.setNombre(contacto.getNombre());
        contactoFromDB.setApellido(contacto.getApellido());
        contactoFromDB.setCelular(contacto.getCelular());
        contactoFromDB.setEmail(contacto.getEmail());
        contactoFromDB.setFechaNacimiento(contacto.getFechaNacimiento());
        contactoService.update(contactoFromDB);
        ra.addFlashAttribute("msgExito", "El contacto se ha actualizado correctamente");
        return "redirect:/index";
    }


    @PostMapping("/{id}/eliminar")
    String eliminar(
            @PathVariable Long id,
            RedirectAttributes ra
            ) {

        ContactoEntity contactoFromDB = contactoService.getById(id);
        contactoService.delete(contactoFromDB);
        ra.addFlashAttribute("msgExito", "El contacto se ha eliminado correctamente");
        return "redirect:/index";
    }


}
