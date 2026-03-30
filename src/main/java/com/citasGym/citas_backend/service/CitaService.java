package com.citasGym.citas_backend.service;

import com.citasGym.citas_backend.model.Cita;
import com.citasGym.citas_backend.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {
    @Autowired
    private CitaRepository citaRepository;
    public List<Cita> findAll(){
        return citaRepository.findAll();
    }
    public Cita findById(long id){
        return citaRepository.findById(id).orElseThrow(()->new RuntimeException("no hay citas con ese id"));
    }
    public Cita save(Cita cita){
        return citaRepository.save(cita);
    }
    public void eliminarporId(long id){
        citaRepository.deleteById(id);
    }
    }

