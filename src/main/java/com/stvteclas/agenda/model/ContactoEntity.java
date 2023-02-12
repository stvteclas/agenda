package com.stvteclas.agenda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Contacto")
public class ContactoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idcontacto")
    private Long id;

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;

    @PastOrPresent
    private LocalDate fechaNacimiento;

    @Size(max = 15)
    private String celular;
    @Email
    private String email;

    private LocalDateTime fechaRegistro;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "companyId", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private CompanyEntity company;

}
