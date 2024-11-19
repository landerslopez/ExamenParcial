package lopezPezo.MsLanders.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model mav) {
        mav.addAttribute("error", "Ocurrió un error inesperado: " + ex.getMessage());
        return "error";
    }
    
}
