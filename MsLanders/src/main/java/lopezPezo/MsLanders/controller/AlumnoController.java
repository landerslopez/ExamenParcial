package lopezPezo.MsLanders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lopezPezo.MsLanders.model.AlumnoModel;
import lopezPezo.MsLanders.services.AlumnoService;

@RestController
@RequestMapping("alumno")
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;
    
    @GetMapping("/findAll")
    public List<AlumnoModel> FindAll()
    {
        List<AlumnoModel> lista = alumnoService.findAll();
        return lista;
    }
    

    @PostMapping("/create")
    public AlumnoModel create(@RequestBody AlumnoModel model)
    {   
        return alumnoService.add(model);
    }

    // findById
    @GetMapping("/findById/{id}")
    public AlumnoModel findById(@PathVariable Integer id) {
        return alumnoService.findById(id);
    }

    // update
    @PutMapping("/update/{id}")
    public AlumnoModel update(@PathVariable Integer id, @RequestBody AlumnoModel model) {
        model.setIdAlumno(id);
        return alumnoService.update(model);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        alumnoService.delete(id);
        return "Usuario eliminado con éxito";
    }
}
