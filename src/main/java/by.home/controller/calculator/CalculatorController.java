package by.home.controller.calculator;

import by.home.configuration.WebConfiguration;
import by.home.service.CalculatorService;
import by.home.service.HistoryCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/calc")
public class CalculatorController {

    @Autowired
    private HistoryCalculatorService historyCalculatorService;
    @Autowired
    private  CalculatorService calculatorService;

    @GetMapping
    public String getCalc(){
        return "calc";
    }

    @PostMapping
    public String postCalc(float fNum, float sNum, String oper, Model model){
        String result = calculatorService.getResult(fNum, sNum, oper);
        historyCalculatorService.saveOperation(result);
        model.addAttribute("result",result);
        return "calc";
    }
}
