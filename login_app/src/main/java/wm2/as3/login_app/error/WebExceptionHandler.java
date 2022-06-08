package wm2.as3.login_app.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class WebExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneralExceptions(Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/errors/error_page");
        mv.addObject("exception", ex);
        return mv;
    }
}
