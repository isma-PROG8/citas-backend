package com.citasGym.citas_backend.controller;

import com.citasGym.citas_backend.model.Servicio;
import com.citasGym.citas_backend.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServicioController {
    @Autowired
    private ServicioService servicioService;
    @GetMapping
    public List<Servicio> mostrarTodosServicios(){
        return servicioService.buscarTodosServicios();
    }
    @GetMapping("/{id}")
    public Servicio mostrarServicioPorId(@PathVariable Long id){
        return servicioService.buscarServicioPorId(id);
    }
    @PostMapping
    public Servicio crearServicio(@RequestBody Servicio servicio){
        return servicioService.guardarServicio(servicio);
    }
    @PutMapping("/{id}")
    public Servicio editarServicioPorId(@PathVariable Long id, @RequestBody Servicio servicio){
        servicio.setId(id);
        return servicioService.guardarServicio(servicio);
    }
    @DeleteMapping("/{id}")
    public void eliminarServicioPorId(@PathVariable Long id){
        servicioService.eliminarServicioPorId(id);
    }
}
