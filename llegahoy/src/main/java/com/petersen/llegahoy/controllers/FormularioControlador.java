package com.petersen.llegahoy.controllers;

import com.petersen.llegahoy.entidades.Formulario;
import com.petersen.llegahoy.services.iFormularioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/formulario"})
public class FormularioControlador {

    private final iFormularioService servicio;

    public FormularioControlador(iFormularioService servicio) {
        this.servicio = servicio;
    }


    // este método sirve para mostrar todos los formularios enviados y ya guardados en la base de datos
    @GetMapping("/personas")
    public List<Formulario> mostrarFormularios() {
        return servicio.mostrarTodosLosFormularios();
    }

    // este método sirve para que un usuario pueda enviar y guardar un formulario
    @PostMapping("/personas")
    public Formulario nuevoFormulario(@RequestBody Formulario form) {
        return servicio.cargarNuevoFormulario(form);
    }

}
