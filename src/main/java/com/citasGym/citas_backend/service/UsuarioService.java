package com.citasGym.citas_backend.service;


import com.citasGym.citas_backend.model.Usuario;
import com.citasGym.citas_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public List<Usuario>obtenerUsuarios(){
        return usuarioRepository.findAll();
    }
    public Usuario obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario no encontrado"));

    }
    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public void  eliminarUsuarioPorId(Long id){
        usuarioRepository.deleteById(id);

    }
}
