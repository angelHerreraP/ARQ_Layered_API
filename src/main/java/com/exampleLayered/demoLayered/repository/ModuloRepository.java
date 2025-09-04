package com.exampleLayered.demoLayered.repository;
import java.util.*;
import com.exampleLayered.demoLayered.model.Modulo;
import com.exampleLayered.demoLayered.model.Nivel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModuloRepository extends JpaRepository<Modulo, Integer> {
    Optional<Modulo> findByTitulo(String titulo);
    List<Modulo> findByNivel(Nivel nivel);
}
