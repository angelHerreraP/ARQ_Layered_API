package com.exampleLayered.demoLayered.service;
import java.util.*;
import com.exampleLayered.demoLayered.model.Modulo;
import com.exampleLayered.demoLayered.model.Nivel;


public interface ModuloService {
    Modulo crearModulo(Modulo modulo);
    List<Modulo> listAllModulos();
    List<Modulo> listByNivel(Nivel nivel);
    public void eliminarModulo(int id); //this is void bc wont return anything
    Optional<Modulo> findById(int id);
}
