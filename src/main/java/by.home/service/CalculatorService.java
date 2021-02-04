package by.home.service;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {
    private float sum(float fNum, float sNum){
        float result = fNum + sNum;
        return result;
    }

    private float mult(float fNum, float sNum){
        float result = fNum * sNum;
        return result;
    }

    private float div(float fNum, float sNum){
        float result = fNum / sNum;
        return result;
    }

    private float diff(float fNum, float sNum){
        float result = fNum - sNum;
        return result;
    }

    public String getResult(float fNum, float sNum, String oper){
        switch (oper){
            case "sum":
                return fNum+" + "+sNum+" = "+sum(fNum, sNum);
            case "div":
                if(sNum != 0){
                    return fNum+" / "+sNum+" = "+div(fNum, sNum);
                }else {
                    return "Divided by zero!";
                }
            case "mult":
                return fNum+" * "+sNum+" = "+mult(fNum, sNum);
            case "diff":
                return fNum+" - "+sNum+" = "+diff(fNum, sNum);
            default:
                return "Wrong operation!";
        }
    }
}
