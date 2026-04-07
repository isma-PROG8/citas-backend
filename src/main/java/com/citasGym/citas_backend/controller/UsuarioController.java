package com.citasGym.citas_backend.controller;

import com.citasGym.citas_backend.model.Usuario;
import com.citasGym.citas_backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public List<Usuario> mostrarUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    @GetMapping("/{id}")
    public Usuario mostrarUsuarioPorId(@PathVariable Long id){
        return usuarioService.obtenerUsuarioPorId(id);
    }
    @PostMapping
    public Usuario agregarUsuario(@RequestBody Usuario usuario){
       return usuarioService.guardarUsuario(usuario);
    }
    @PutMapping("/{id}")
    public Usuario editarUsuarioPorId(@PathVariable Long id, @RequestBody Usuario usuario){
        usuario.setId(id);
        return usuarioService.guardarUsuario(usuario);
    }
    @DeleteMapping("/{id}")
    public void eliminarUsuarioPorId(@PathVariable Long id){
        usuarioService.eliminarUsuarioPorId(id);
    }
}
