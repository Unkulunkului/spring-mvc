package by.home.service;

import by.home.storage.HistoryCalculatorStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryCalculatorService {

    @Autowired
    private HistoryCalculatorStorage historyCalculatorStorage;

    public List<String> getHistory() {
        List <String> history = historyCalculatorStorage.getHistory();
        return new ArrayList<>(history);
    }

    public void saveOperation(String oper){
        historyCalculatorStorage.saveOperation(oper);
    }

}
