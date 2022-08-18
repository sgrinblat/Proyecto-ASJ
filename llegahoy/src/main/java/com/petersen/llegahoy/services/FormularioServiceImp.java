package com.petersen.llegahoy.services;

import com.petersen.llegahoy.entidades.Formulario;
import com.petersen.llegahoy.repositories.iFormularioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FormularioServiceImp implements iFormularioService {

    @Autowired
    private iFormularioRepo iFormularioRepo;


    @Override
    public List<Formulario> mostrarTodosLosFormularios() {
        return iFormularioRepo.findAll();
    }

    @Override
    public Formulario cargarNuevoFormulario(@RequestBody Formulario formularioLlenado) {
        return iFormularioRepo.save(formularioLlenado);
    }
}
