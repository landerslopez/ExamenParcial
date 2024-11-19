package com.example.ApiRest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiRest.model.AlumnoModel;
import com.example.ApiRest.router.ApiRoutes;
import com.example.ApiRest.service.AlumnoService;

@RestController
@RequestMapping(ApiRoutes.ALUMNOS_BASE)
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);

    @GetMapping
    public List<AlumnoModel> listarAlumnos() {
        logger.info("Listando todos los alumnos");
        return alumnoService.listarTodos();
    }

    @PostMapping
    public AlumnoModel agregarAlumno(@RequestBody AlumnoModel alumno) {
        logger.info("Agregando alumno");
        return alumnoService.guardar(alumno);
    }

    @GetMapping("/{id}")
    public AlumnoModel obtenerAlumno(@PathVariable Integer id) {
        logger.info("Buscando alumno");
        return alumnoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public AlumnoModel actualizarAlumno(@PathVariable Integer id, @RequestBody AlumnoModel alumno) {
        logger.info("Actualizando alumno");
        return alumnoService.actualizar(id, alumno);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id) {
        logger.info("Eliminando alumno");
        alumnoService.eliminar(id);
    }

}
