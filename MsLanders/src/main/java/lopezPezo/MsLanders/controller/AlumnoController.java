package lopezPezo.MsLanders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lopezPezo.MsLanders.model.AlumnoModel;
import lopezPezo.MsLanders.services.AlumnoService;

//@RestController //Para hacer consulta http y que devuelva datos en formato json
@Controller //Para manejar las vistas en html
@RequestMapping("/alumno")

public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;
    
    @GetMapping("/listAlumno")
    public ModelAndView listStudents()
    { 
        ModelAndView mav = new ModelAndView("listAlumno");
        mav.addObject("alumnos", alumnoService.findAllStudent());
		mav.addObject("alumno", new AlumnoModel());
		mav.addObject("accion","/alumno/create");
        return mav;
    }
    

    @PostMapping("/create")
    public AlumnoModel create(@RequestBody AlumnoModel model)
    {   
        return alumnoService.addStudent(model);
    }

    // findById
    @GetMapping("/findById/{id}")
    public AlumnoModel findById(@PathVariable Integer id) {
        return alumnoService.findByIdStudent(id);
    }

    // update
    @PutMapping("/update/{id}")
    public AlumnoModel update(@PathVariable Integer id, @RequestBody AlumnoModel model) {
        model.setIdAlumno(id);
        return alumnoService.updateStudent(model);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        alumnoService.deleteStudent(id);
        return "Usuario eliminado con éxito";
    }
}
