package com.petersen.llegahoy.services;

import com.petersen.llegahoy.entidades.Usuario;

import java.util.List;
import java.util.Optional;

public interface iUsuarioService {

    List<Usuario> mostrarUsuarios();

    Optional <Usuario> loguearUsuario(Usuario user);

    Usuario registrarUsuario(Usuario userRegistrado);

    public void eliminarUsuario(Usuario user);

    Usuario actualizarUsuario(Usuario usuarioActualizado);
}
