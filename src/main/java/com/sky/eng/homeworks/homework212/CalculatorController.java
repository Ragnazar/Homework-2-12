package com.sky.eng.homeworks.homework212;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorUtils calculatorUtils;

    private CalculatorController(CalculatorUtils calculatorUtils) {
        this.calculatorUtils = calculatorUtils;
    }

    @GetMapping()
    public String hello() {
        return calculatorUtils.hello();
    }


    @GetMapping(path = "/plus")
    public String sum(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " + " + num2 + " = " + calculatorUtils.calcSum(num1, num2);
    }

    @GetMapping(path = "/minus")
    public String subtract(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " - " + num2 + " = " + calculatorUtils.calcSubtract(num1, num2);
    }

    @GetMapping(path = "/multiply")
    public String multiplication(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        return num1 + " * " + num2 + " = " + calculatorUtils.calcMultiply(num1, num2);
    }

    @GetMapping(path = "/divide")
    public String division(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        if (num2 != 0) {
            return num1 + " / " + num2 + " = " + calculatorUtils.calcDivision(num1, num2);
        } else {
            return "Деление на ноль!";
        }
    }
}
