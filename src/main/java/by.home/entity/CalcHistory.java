package by.home.entity;

import java.util.ArrayList;
import java.util.List;

public class CalcHistory {
    private List<Operation> operationList = new ArrayList<>();

    public List<Operation> getOperationList() {
        return new ArrayList<>(operationList);
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    public void add(Operation operation){
        operationList.add(operation);
    }

}
