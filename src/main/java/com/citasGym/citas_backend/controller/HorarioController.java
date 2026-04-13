package com.citasGym.citas_backend.controller;

import com.citasGym.citas_backend.model.Horario;
import com.citasGym.citas_backend.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {
    @Autowired
    private HorarioService horarioService;
    @GetMapping
    public List<Horario> mostrarHorarios(){
        return horarioService.buscarHorarios();
    }
    @GetMapping("/{id}")
    public Horario mostrarHorarioPorId(@PathVariable Long id){
        return horarioService.buscarHorarioPorId(id);
    }
    @PostMapping
    public Horario añadirHorario(@RequestBody Horario horario){
        return horarioService.guardarHorario(horario);
    }
    @PutMapping("/{id}")
    public Horario editarHorarioPorId(@PathVariable Long id,@RequestBody Horario horario){
        horario.setId(id);
        return horarioService.guardarHorario(horario);
    }
    @DeleteMapping("/{id}")
    public void eliminarHorarioPorId(@PathVariable Long id){
        horarioService.eliminarHorarioPorId(id);
    }
}
