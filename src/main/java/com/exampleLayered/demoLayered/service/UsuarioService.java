package com.exampleLayered.demoLayered.service;
import java.util.*;
import com.exampleLayered.demoLayered.model.Usuario;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Usuario buscarPorId(UUID id);
    Usuario actualizarUsuario(UUID id, Usuario usuario);
    void eliminarUsuario(UUID id);
}
