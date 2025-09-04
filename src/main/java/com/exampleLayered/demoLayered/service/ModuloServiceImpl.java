package com.exampleLayered.demoLayered.service;
import com.exampleLayered.demoLayered.model.Nivel;
import com.exampleLayered.demoLayered.model.Modulo;
import com.exampleLayered.demoLayered.repository.ModuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuloServiceImpl implements ModuloService{

    //Bring repository first
    private final ModuloRepository moduloRepository;


    //This 'constructor" request Repository methods or implementations
    public ModuloServiceImpl(ModuloRepository moduloRepository){
        this.moduloRepository = moduloRepository;
    }

    //this is a method form service, but also need moduel and Repository
    @Override
    public Modulo crearModulo(Modulo modulo) {
        //you need to check if theres no other with that name, so if you go to ModuloRepository, there is a findByTitulo
        if(moduloRepository.findByTitulo(modulo.getTitulo()).isPresent()){
            throw new IllegalArgumentException("This course already exist!");
        }
        //If there no module with that name
        return moduloRepository.save(modulo);// .save is another method from JPA
    }

    @Override
    public List<Modulo> listAllModulos() {
        return moduloRepository.findAll(); //JPA has many implemented methods as this
    }

    //So, in this case, we have a proble, we call a list by level
    @Override
    public List<Modulo> listByNivel(Nivel nivel){
        return moduloRepository.findByNivel(nivel);
    }

    @Override
    public void eliminarModulo(int id) {
        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("This module doesnt exist"));
        moduloRepository.delete(modulo);
    }

    @Override
    public Optional<Modulo> findById(int id) {
        return moduloRepository.findById(id);
    }
}
