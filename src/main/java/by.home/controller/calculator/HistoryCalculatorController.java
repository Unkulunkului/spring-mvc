package by.home.controller.calculator;

import by.home.entity.Operation;
import by.home.service.CalculatorService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(path = "/history")
public class HistoryCalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    @GetMapping
    public ModelAndView getHistory(ModelAndView model, HttpSession httpSession){
        List<Operation> history = calculatorService.getOperationList();
        if(httpSession.getAttribute("user") != null){
            httpSession.setAttribute("history", history);
        }
        return model;
    }
}
