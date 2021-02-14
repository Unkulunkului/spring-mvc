package by.home.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public String getPage(Model model, RuntimeException e){
        model.addAttribute("error", e.getMessage());
        return "error";
    }
}
