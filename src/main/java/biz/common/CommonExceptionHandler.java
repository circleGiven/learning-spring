package biz.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("biz")
public class CommonExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView handlerArithmeticException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("/common/arithmeticError.jsp");
        return modelAndView;
    }

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView handlerNullPointException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("/common/nullPointerError.jsp");
        return modelAndView;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("/common/error.jsp");
        return modelAndView;
    }
}
