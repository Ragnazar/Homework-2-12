package pro.sky.homeworks.homework212.services;

import org.springframework.stereotype.Service;
import pro.sky.homeworks.homework212.exceptions.DivideByZeroException;

@Service
public class CalculatorUtilsImpl implements CalculatorUtils {
    @Override
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public int calcSum(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int calcSubtract(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int calcMultiply(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public double calcDivision(int num1, int num2) {
        if (num2 == 0) {
            throw new DivideByZeroException("Деление на ноль!");
        }
        return (double) num1 / num2;

    }
}
