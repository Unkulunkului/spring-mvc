package by.home.storage;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryCalculatorStorage {
    private List<String> history = new ArrayList<>();

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    public void saveOperation(String oper){
        history.add(oper);
    }
}
