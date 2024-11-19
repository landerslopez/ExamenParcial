package lopezPezo.MsLanders.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException {
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView mav = new ModelAndView("errorPage");
        mav.addObject("error", "Ocurrió un error inesperado: " + ex.getMessage());
        return mav;
    }

    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormatException(NumberFormatException ex) {
        ModelAndView mav = new ModelAndView("errorPage");
        mav.addObject("error", "Formato de número inválido: " + ex.getMessage());
        return mav;
    }
    
}
