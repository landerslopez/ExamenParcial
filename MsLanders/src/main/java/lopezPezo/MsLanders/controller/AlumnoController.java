package lopezPezo.MsLanders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lopezPezo.MsLanders.model.AlumnoModel;
import lopezPezo.MsLanders.services.AlumnoServiceImpl;

//@RestController //Para hacer consulta http y que devuelva datos en formato json
@Controller //Para manejar las vistas en html
@RequestMapping("/alumno")
public class AlumnoController {
    @Autowired
    private AlumnoServiceImpl alumnoService;
    
    @GetMapping("/listAlumno")
    public String listStudents(Model mav)    { 
        mav.addAttribute("alumnos", alumnoService.findAllStudent());
		mav.addAttribute("alumno", new AlumnoModel());
		mav.addAttribute("accion","/alumno/create");
        return "listAlumno";
    }
    

    @PostMapping("/create")
    public String createAlumno(@ModelAttribute(name="alumno") @Validated AlumnoModel model ){   
        alumnoService.addStudent(model);
        return "redirect:/alumno/listAlumno";
    }

    // findById
    @GetMapping("/findById/{id}")
    public String findById(@PathVariable(name="id") String id, Model mav) {
        mav.addAttribute("alumnos", alumnoService.findAllStudent());
        AlumnoModel u = alumnoService.findByIdStudent(Integer.parseInt(id));
		mav.addAttribute("alumno", u);
		mav.addAttribute("accion","/alumno/update");
        return "listAlumno";
    }

    // update
    @PostMapping("/update")
    public String editAlumno(@ModelAttribute(name = "alumno") AlumnoModel model) {
        alumnoService.updateStudent(model, model.getIdAlumno());
        return "redirect:/alumno/listAlumno"; 
    }

    // delete
    @GetMapping ("/delete/{id}")
    public String deleteAlumno(@PathVariable(name = "id") String id) {
        alumnoService.deleteStudent(Integer.parseInt(id));
		return "redirect:/alumno/listAlumno";
    }
}
