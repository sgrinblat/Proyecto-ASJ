package com.petersen.llegahoy.controllers;

import com.petersen.llegahoy.entidades.Usuario;
import com.petersen.llegahoy.services.iUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UsuarioControlador {

    @Autowired
    private final iUsuarioService servicio;

    public UsuarioControlador(iUsuarioService servicio) {
        this.servicio = servicio;
    }

    // método con el cual podemos listar los usuarios registrados en el sistema
    @GetMapping("/personas")
    public List<Usuario> mostrarTodosUsuarios() {
        return servicio.mostrarUsuarios();
    }

    // método para ingresar al sistema con un usuario previamente registrado
    @PostMapping("/personas")
    public ResponseEntity <?> loginUser(@RequestBody Usuario userData) {
        Optional <Usuario> user = servicio.loguearUsuario(userData);
        if(user.get().getUserPassword().equals(userData.getUserPassword())) {
            return ResponseEntity.ok(user);
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }

    // método para registrar un usuario nuevo, comprobando antes si el username no existe en la base de datos
    @RequestMapping(value = "/registros", method = RequestMethod.POST)
    @ResponseBody
    public void registrarNuevoUsuario(@RequestBody Usuario userData) throws Exception {
        Optional <Usuario> user = servicio.loguearUsuario(userData);
        if(user.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario ingresado ya existe!");
        } else {
            servicio.registrarUsuario(userData);
        }
    }

}
