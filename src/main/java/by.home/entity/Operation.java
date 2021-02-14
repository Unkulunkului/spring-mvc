package by.home.entity;

import javax.validation.constraints.*;

public class Operation {

    @Max(value = 100)
    @Min(value = -100)
    private double fNum;
    @Max(value = 100)
    @Min(value = -100)
    private double sNum;

    private String oper;
    private double result;

    public Operation() {
    }

    public Operation(double fNum, double sNum, String oper) {
        this.fNum = fNum;
        this.sNum = sNum;
        this.oper = oper;
    }

    public double getFNum() {
        return fNum;
    }

    public void setFNum(double fNum) {
        this.fNum = fNum;
    }

    public double getSNum() {
        return sNum;
    }

    public void setSNum(double sNum) {
        this.sNum = sNum;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "fNum=" + fNum +
                ", sNum=" + sNum +
                ", oper='" + oper + '\'' +
                ", result=" + result +
                '}';
    }

}
