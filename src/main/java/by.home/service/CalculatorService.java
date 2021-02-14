package by.home.service;

import by.home.entity.Operation;
import by.home.storage.HistoryCalculatorStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CalculatorService {

    @Autowired
    private HistoryCalculatorStorage historyCalculatorStorage;

    private double sum(double fNum, double sNum){
        double result = fNum + sNum;
        return result;
    }

    private double mult(double fNum, double sNum){
        double result = fNum * sNum;
        return result;
    }

    private double div(double fNum, double sNum){
        double result = fNum / sNum;
        return result;
    }

    private double diff(double fNum, double sNum){
        double result = fNum - sNum;
        return result;
    }

    public Operation getResult(Operation oper){
        switch (oper.getOper()){
            case "sum":
                oper.setResult(sum(oper.getFNum(), oper.getSNum()));
                break;
            case "div":
                oper.setResult(div(oper.getFNum(), oper.getSNum()));
                break;
            case "mult":
                oper.setResult(mult(oper.getFNum(), oper.getSNum()));
                break;
            case "diff":
                oper.setResult(diff(oper.getFNum(), oper.getSNum()));
                break;
        }
        return oper;
    }

//    public List<Operation> getOperationList(){
//        return historyCalculatorStorage.getHistory();
//    }
}
