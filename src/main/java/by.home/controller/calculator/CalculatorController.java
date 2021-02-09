package by.home.controller.calculator;

import by.home.entity.Operation;
import by.home.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/calc")
public class CalculatorController {

    @Autowired
    private  CalculatorService calculatorService;

    @GetMapping
    public ModelAndView getCalc(ModelAndView modelAndView){
        modelAndView.setViewName("calc");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView postCalc(Operation oper, ModelAndView model){
        Operation result = calculatorService.getResult(oper);
        model.setViewName("calc");
        model.addObject("result",result);
        return model;
    }
}
