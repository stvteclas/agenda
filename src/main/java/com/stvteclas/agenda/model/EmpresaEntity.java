package com.stvteclas.agenda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "Empresa")
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idempresa")
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String direccion;


    @Size(max = 15)
    private String celular;
    @Email
    private String email;

    private LocalDateTime fechaRegistro;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ContactoEntity> contacto;

    public List<String> getcontacto() {
        return contacto.stream()
                .map(ContactoEntity::getNombre)
                .toList();

    }


}
