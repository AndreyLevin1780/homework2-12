package pro.sky.calculatortest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculatortest.exception.DivisionByZeroException;
import pro.sky.calculatortest.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String showHelloMessage() {
        return "Добро пожаловать в калькулятор.";
    }

    private String checkParameters(Integer num1, Integer num2) {
        if (num1 == null) {
            return "Параметр 1 не задан.";
        } else if (num2 == null) {
            return "Параметр 2 не задан.";
        }
        return null;
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Integer num1, @RequestParam (required = false) Integer num2) {
        String checkResult = checkParameters(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else {
            return num1 + "+" + num2 + "=" + calculatorService.plus(num1, num2);}
    };

    public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        String checkResult = checkParameters(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else {
            return num1 + "-" + num2 + "=" + calculatorService.minus(num1, num2);
        }
    }
    public String multiply (@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        String checkResult = checkParameters(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else {
            return num1 + "*" + num2 + "=" + calculatorService.multiply(num1, num2);
        }
    }

    @GetMapping("/divide")
    public String divide(@RequestParam (required = false) Integer num1, @RequestParam (required = false) Integer num2) {
        String checkResult = checkParameters(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else if (num2 == 0) {
            throw new DivisionByZeroException();
        } else {
            return num1 + "/" + num2 + "=" + calculatorService.divide(num1, num2);}
    };
}
