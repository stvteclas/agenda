package com.stvteclas.agenda.controller;

import com.stvteclas.agenda.model.EmpresaEntity;
import com.stvteclas.agenda.service.EmpresaService;
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

@Controller
@AllArgsConstructor
@RequestMapping
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/index")
    String index(Pageable pageable, @RequestParam(required = false) String busqueda, Model model) {
        Page<EmpresaEntity> empresaPage ;
        if (busqueda !=null && busqueda.trim().length()> 0){
            empresaPage = empresaService.findByNombreContaining(busqueda, pageable);
        }else {
            empresaPage = empresaService.findAll(pageable);
        }

        model.addAttribute("empresaPage", empresaPage);
        return "index";
    }

    @GetMapping("/empresa")
    String nuevo(Model model) {
        model.addAttribute("empresa", new EmpresaEntity());
        return "empresa";
    }

    @PostMapping("/empresa")
    String crear(@Validated EmpresaEntity empresa, BindingResult bindingResult, RedirectAttributes ra, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("empresa", empresa);
            return "empresa";
        }
        empresaService.save(empresa);
        ra.addFlashAttribute("msgExito", "La empresa se ha creado correctamente");
        return "redirect:/index";
    }

    @GetMapping("/{id}/editarempresa")
    String editar(@PathVariable Long id, Model model) {
        EmpresaEntity empresa = empresaService.getById(id);
        model.addAttribute("empresa", empresa);
        return "editarempresa";
    }

    @PostMapping("/{id}/editarempresa")
    String actualizar(
            @PathVariable Long id,
            @Validated EmpresaEntity empresa,
            BindingResult bindingResult,
            RedirectAttributes ra,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("empresa", empresa);
            return "editarempresa";
        }
        EmpresaEntity empresaFromDB = empresaService.getById(id);
        empresaFromDB.setNombre(empresa.getNombre());
        empresaFromDB.setDireccion(empresa.getDireccion());
        empresaFromDB.setCelular(empresa.getCelular());
        empresaFromDB.setEmail(empresa.getEmail());
        empresaService.update(empresaFromDB);
        ra.addFlashAttribute("msgExito", "La Empresa se ha actualizado correctamente");
        return "redirect:/index";
    }


    @PostMapping("/{id}/eliminarempresa")
    String eliminar(
            @PathVariable Long id,
            RedirectAttributes ra
    ) {

        EmpresaEntity empresaFromDB = empresaService.getById(id);
        empresaService.delete(empresaFromDB);
        ra.addFlashAttribute("msgExito", "La Empresa se ha eliminado correctamente");
        return "redirect:/index";
    }


}
