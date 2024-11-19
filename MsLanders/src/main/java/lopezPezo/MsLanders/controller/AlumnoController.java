package lopezPezo.MsLanders.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lopezPezo.MsLanders.model.AlumnoModel;
import lopezPezo.MsLanders.services.AlumnoServiceImpl;
import lopezPezo.MsLanders.router.ApiRouter;

//@RestController //Para hacer consulta http y que devuelva datos en formato json
@Controller // Para manejar las vistas en html
@RequestMapping(ApiRouter.ALUMNOS_BASE)
public class AlumnoController {

    @Autowired
    private AlumnoServiceImpl alumnoService;

    private static final Logger logger = LoggerFactory.getLogger(AlumnoController.class);

    @GetMapping("/listAlumno")
    public String listStudents(Model mav) {
        logger.info("Listando todos los alumnos");
        mav.addAttribute("alumnos", alumnoService.findAllStudent());
        mav.addAttribute("alumno", new AlumnoModel());
        mav.addAttribute("accion", "/alumno/create");
        return "listAlumno";
    }

    @PostMapping("/create")
    public String createAlumno(@ModelAttribute(name = "alumno") @Validated AlumnoModel model,
            BindingResult bindingResult, Model mav) {

        if (bindingResult.hasErrors()) {
            mav.addAttribute("alumnos", alumnoService.findAllStudent());
            logger.info("Agregando alumnos");
            mav.addAttribute("accion", "/alumno/create");
            return "listAlumno";
        }
        alumnoService.addStudent(model);
        return "redirect:/alumno/listAlumno";
    }

    // findById
    @GetMapping("/findById/{id}")
    public String findById(@PathVariable(name = "id") String id, Model mav) {
        mav.addAttribute("alumnos", alumnoService.findAllStudent());
        AlumnoModel u = alumnoService.findByIdStudent(Integer.parseInt(id));
        logger.info("Buscando alumnos");
        mav.addAttribute("alumno", u);
        mav.addAttribute("accion", "/alumno/update");
        return "listAlumno";
    }

    // update
    @PostMapping("/update")
    public String editAlumno(@ModelAttribute(name = "alumno") AlumnoModel model,
            BindingResult bindingResult, Model mav) {
                
        if (bindingResult.hasErrors()) {
            mav.addAttribute("alumnos", alumnoService.findAllStudent());
            logger.info("Editando alumno");
            mav.addAttribute("accion", "/alumno/update");
            return "listAlumno";
        }
        alumnoService.updateStudent(model, model.getIdAlumno());
        return "redirect:/alumno/listAlumno";
    }

    // delete
    @GetMapping("/delete/{id}")
    public String deleteAlumno(@PathVariable(name = "id") String id) {
        logger.info("Elimiando alumno");
        alumnoService.deleteStudent(Integer.parseInt(id));
        return "redirect:/alumno/listAlumno";
    }
}
