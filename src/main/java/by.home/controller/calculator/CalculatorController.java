package by.home.controller.calculator;

import by.home.entity.CalcHistory;
import by.home.entity.Operation;
import by.home.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/calc")
public class CalculatorController {

    @Autowired
    private  CalculatorService calculatorService;


    @GetMapping
    public ModelAndView getCalc(ModelAndView modelAndView){
        modelAndView.addObject("ModelAttributeCalc", new Operation());
        modelAndView.setViewName("calc");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView postCalc(@Valid @ModelAttribute("ModelAttributeCalc") Operation oper,
                                 BindingResult bindingResult, ModelAndView model, HttpSession httpSession){
        if (!bindingResult.hasErrors()) {
            if(!(oper.getOper().equals("div") && oper.getSNum() == 0)){
                Operation result = calculatorService.getResult(oper);
                if(result != null){
                    CalcHistory calcHistory = (CalcHistory) httpSession.getAttribute("calcHistory");
                    calcHistory.add(result);
                    httpSession.setAttribute("calcHistory", calcHistory);
                    model.addObject("result",result);
                }else {
                    model.addObject("result", "Incorrect operation");
                }
            }else {
                model.addObject("result","Divided by zero!");
            }
        }
        model.setViewName("calc");
        return model;
    }
}
