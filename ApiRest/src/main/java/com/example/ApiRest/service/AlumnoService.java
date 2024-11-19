package com.example.ApiRest.service;

import java.util.List;

import com.example.ApiRest.model.AlumnoModel;

public interface AlumnoService {
    List<AlumnoModel> listarTodos();

    AlumnoModel obtenerPorId(Integer id);

    AlumnoModel guardar(AlumnoModel alumno);

    AlumnoModel actualizar(Integer id, AlumnoModel alumno);

    void eliminar(Integer id);
}
