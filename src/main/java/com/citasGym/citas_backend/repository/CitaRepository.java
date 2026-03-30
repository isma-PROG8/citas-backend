package com.citasGym.citas_backend.repository;

import com.citasGym.citas_backend.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> id(Long id);
}
