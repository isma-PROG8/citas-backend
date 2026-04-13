package com.citasGym.citas_backend.service;


import com.citasGym.citas_backend.model.Usuario;
import com.citasGym.citas_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<Usuario>obtenerUsuarios(){
        return usuarioRepository.findAll();
    }
    public Usuario obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuario no encontrado"));

    }
    public Usuario guardarUsuario(Usuario usuario){
        usuario.setPasswordHash(passwordEncoder.encode(usuario.getPasswordHash()));
        return usuarioRepository.save(usuario);
    }
    public void  eliminarUsuarioPorId(Long id){
        usuarioRepository.deleteById(id);

    }
    public Usuario obtenerUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
