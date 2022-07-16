package handler;

import annotation.Math;

public class Summation {
    private int num1;
    private int num2;

    public Summation(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Summation() {
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    @Math(num1 = 100, num2 = 200)
    public void mathSum(int num1, int num2) {
        int num3 = num1 + num2;
        System.out.println("Сумма num1 + num2 = " + num3);
    }

}
