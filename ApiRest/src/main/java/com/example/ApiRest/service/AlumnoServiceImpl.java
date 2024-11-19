package com.example.ApiRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiRest.model.AlumnoModel;
import com.example.ApiRest.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{

    @Autowired
    private AlumnoRepository repository;

    @Override
    public List<AlumnoModel> listarTodos() {
        return repository.findAll();
    }

    @Override
    public AlumnoModel obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id));
    }

    @Override
    public AlumnoModel guardar(AlumnoModel alumno) {
        return repository.save(alumno);
    }

    @Override
    public AlumnoModel actualizar(Integer id, AlumnoModel alumno) {
        AlumnoModel existente = obtenerPorId(id);
        existente.setNombre(alumno.getNombre());
        existente.setNota(alumno.getNota());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No existe el alumno con id: " + id);
        }
        repository.deleteById(id);
    }
    
}
