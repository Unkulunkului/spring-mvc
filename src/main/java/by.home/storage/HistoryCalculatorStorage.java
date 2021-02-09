package by.home.storage;

import by.home.entity.Operation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryCalculatorStorage {
    private List<Operation> history = new ArrayList<>();

    public List<Operation> getHistory() {
        return new ArrayList<>(history);
    }

    public void saveOperation(Operation oper){
        history.add(oper);
    }

    public void clearHistory(){
        history.clear();
    }
}
