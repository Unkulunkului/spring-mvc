package by.home.service;

import by.home.configuration.WebConfiguration;
import by.home.storage.HistoryCalculatorStorage;
import com.sun.xml.internal.ws.developer.SchemaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
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
