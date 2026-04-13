package com.citasGym.citas_backend.controller;

import com.citasGym.citas_backend.config.JwtUtil;
import com.citasGym.citas_backend.dto.LoginRequest;
import com.citasGym.citas_backend.dto.LoginResponse;
import com.citasGym.citas_backend.model.Usuario;
import com.citasGym.citas_backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JwtUtil JwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest Request) {
        String email = Request.getEmail();
        String password = Request.getPassword();
        Usuario usuarioEncontrado= usuarioService.obtenerUsuarioPorEmail(email);
        if (!passwordEncoder.matches(password, usuarioEncontrado.getPasswordHash())) {
            throw new RuntimeException("Contraseña incorrecta");
        }
        return new LoginResponse(JwtUtil.generarToken(email));

    }

}
