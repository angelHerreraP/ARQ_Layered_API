package com.exampleLayered.demoLayered.service;
import com.exampleLayered.demoLayered.model.Usuario;
import com.exampleLayered.demoLayered.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class UsuarioServiceImpl implements UsuarioService {


    //genears un objeto de la interfaz
    private final UsuarioRepository usuarioRepository;

    //genera ahora si el constructor
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        if(usuario.getEmail()==null || usuario.getEmail().isEmpty()){
            throw new IllegalArgumentException("Cannot be empty");
        }//Case if its empty
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("This email already exists!");
        }//case if it exists
        return usuarioRepository.save(usuario);//If everything its ok... go
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(UUID id) {
        return usuarioRepository.findById(id).orElseThrow(() ->  new RuntimeException("Usuario no encontrado con "+ id));
    }

    @Override
    public Usuario actualizarUsuario(UUID id, Usuario usuario) {
        return usuarioRepository.findById(id).map(u -> {
            u.setEmail(usuario.getEmail());
            u.setPasswordHash(usuario.getPasswordHash());
            u.setActivo(usuario.isActivo());
            u.setRol(usuario.getRol());
            return usuarioRepository.save(u);
        }).orElseThrow(()-> new RuntimeException("The user with id "+ id + " doesnt exist!"));
    }

    @Override
    public void eliminarUsuario(UUID id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new RuntimeException("This is not a valid id"));
        usuarioRepository.delete(usuario);
    }
}
