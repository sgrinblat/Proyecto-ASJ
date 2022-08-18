package com.petersen.llegahoy.services;

import com.petersen.llegahoy.entidades.Formulario;

import java.util.List;

public interface iFormularioService {

    List<Formulario> mostrarTodosLosFormularios();

    Formulario cargarNuevoFormulario(Formulario formularioLlenado);
}
