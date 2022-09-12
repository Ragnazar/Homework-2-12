package com.sky.eng.homeworks.homework212;

import org.springframework.stereotype.Service;

@Service
class CalculatorUtilsImpl implements CalculatorUtils {
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    public int calcSum(int num1, int num2) {
        return num1 + num2;
    }

    public int calcSubtract(int num1, int num2) {
        return num1 - num2;
    }

    public int calcMultiply(int num1, int num2) {
        return num1 * num2;
    }

    public double calcDivision(int num1, int num2) {

        return (double) num1 / num2;

    }
}
