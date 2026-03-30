package com.citasGym.citas_backend.service;

import com.citasGym.citas_backend.model.Servicio;
import com.citasGym.citas_backend.repository.ServicioRepository;
import com.citasGym.citas_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;
    public List<Servicio> buscarTodosServicios(){
        return servicioRepository.findAll();
    }
    public Servicio buscarServicioPorId(Long id){
        return servicioRepository.findById(id).orElseThrow(()->new RuntimeException("Servicio no encontrado"));
    }
    public Servicio guardarServicio(Servicio servicio){
        return servicioRepository.save(servicio);
    }
    public void eliminarServicioPorId(Long id){
        servicioRepository.deleteById(id);
    }
}
