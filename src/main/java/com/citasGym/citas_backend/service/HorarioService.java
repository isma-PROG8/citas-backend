package com.citasGym.citas_backend.service;

import com.citasGym.citas_backend.model.Horario;
import com.citasGym.citas_backend.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioService {
    @Autowired
    private HorarioRepository horarioRepository;
    public List<Horario> buscarHorarios(){
        return horarioRepository.findAll();
    }
    public Horario buscarHorarioPorId(Long id){
        return horarioRepository.findById(id).orElseThrow(()->new RuntimeException("no existe ese horario"));
    }
    public Horario guardarHorario(Horario horario){
        return horarioRepository.save(horario);
    }
    public void eliminarHorarioPorId(Long id){
        horarioRepository.deleteById(id);
    }
}
