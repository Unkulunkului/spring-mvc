package by.home.controller.calculator;

import by.home.entity.Operation;
import by.home.service.CalculatorService;
import by.home.storage.HistoryCalculatorStorage;
import com.sun.xml.internal.ws.wsdl.writer.document.OpenAtts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getErrorCount());
        }
        if(httpSession.getAttribute("historyCalc") == null){
            httpSession.setAttribute("historyCalc", new ArrayList<Operation>());
        }
        Operation result = calculatorService.getResult(oper);
        List<Operation> operationList = (List<Operation>) httpSession.getAttribute("historyCalc");
        operationList.add(result);
        httpSession.setAttribute("historyCalc", operationList);
        model.addObject("result",result);
        model.setViewName("calc");
        return model;
    }
}
