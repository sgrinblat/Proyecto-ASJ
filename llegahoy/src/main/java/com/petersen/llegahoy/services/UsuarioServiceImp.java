package com.petersen.llegahoy.services;

import com.petersen.llegahoy.entidades.Usuario;
import com.petersen.llegahoy.repositories.iUsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements iUsuarioService {

    @Autowired
    private iUsuarioRepo iUsuarioRepo;

    @Override
    public List<Usuario> mostrarUsuarios() {
        return iUsuarioRepo.findAll();
    }

    @Override
    public Optional<Usuario> loguearUsuario(Usuario user) {
        return iUsuarioRepo.findById(user.getUsername());
    }

    @Override
    public Usuario registrarUsuario(@RequestBody Usuario userRegistrado) {
        return iUsuarioRepo.save(userRegistrado);
    }

}
