package com.citasGym.citas_backend.controller;

import com.citasGym.citas_backend.model.Cita;
import com.citasGym.citas_backend.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {
    @Autowired
    private CitaService citaService;
    @GetMapping
    public List<Cita> mostrarCitas(){
        return citaService.findAll();
    }
    @GetMapping("/{id}")
    public Cita mostrarCitaPorId(@PathVariable Long id){
        return citaService.findById(id);
    }
    @PostMapping
    public Cita añadirCita(@RequestBody Cita cita){
        return citaService.save(cita);
    }
    @PutMapping("/{id}")
    public Cita editarCitaPorId(@PathVariable Long id, @RequestBody Cita cita){
        cita.setId(id);
        return citaService.save(cita);
    }
    @DeleteMapping("/{id}")
    public void eliminarCitaPorId(@PathVariable Long id){
        citaService.eliminarporId(id);
    }

}
