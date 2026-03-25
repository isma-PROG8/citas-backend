package com.citasGym.citas_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="servicios")

public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String nombre;

private String descripcion;
    @NotNull
    @Column(nullable = false)
private Integer duracionMin;
    @NotNull
    @Column(nullable = false)
private BigDecimal precio;
private boolean activo=true;
}
