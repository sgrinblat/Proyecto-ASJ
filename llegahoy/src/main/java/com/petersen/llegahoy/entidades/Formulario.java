package com.petersen.llegahoy.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "formulario")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Formulario {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_formulario;

    @Column(name = "nombre_formulario")
    private String nombre_formulario;

    @Column(name = "apellido_formulario")
    private String apellido_formulario;

    @Column(name = "email_formulario")
    private String email_formulario;

    @Column(name = "mensaje_formulario")
    private String mensaje_formulario;


}
