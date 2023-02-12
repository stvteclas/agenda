package com.stvteclas.agenda.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ContactoRequestDTO {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String celular;
    private String email;
}
