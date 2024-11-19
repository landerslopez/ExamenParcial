package com.example.ApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiRest.model.AlumnoModel;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoModel, Integer>{
    
}
