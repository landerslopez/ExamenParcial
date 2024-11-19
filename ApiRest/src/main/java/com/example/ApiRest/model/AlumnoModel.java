package com.example.ApiRest.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="alumno")
public class AlumnoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer idAlumno;

    @Column(name = "nombre", length = 100, nullable = false)
    public String nombre;

    @Column(name = "nota" , precision = 5 , scale = 2, nullable = false)
    public BigDecimal nota;
}