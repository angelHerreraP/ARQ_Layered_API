package com.exampleLayered.demoLayered.repository;

import com.exampleLayered.demoLayered.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

// extends JpaRepository<Usuario, UUID> nos ahorra muchas lineas de coigo como save(Usuario), look
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByEmail(String email); //Optional es porque puede encontrar algo o nope
}
