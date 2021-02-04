package by.home.controller.calculator;

import by.home.service.HistoryCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/history")
public class HistoryCalculatorController {
    @Autowired
    private HistoryCalculatorService historyCalculatorService;
    @GetMapping
    public String getHistory(Model model){
        List<String>history = historyCalculatorService.getHistory();
        model.addAttribute("history", history);
        return "history";
    }
}
