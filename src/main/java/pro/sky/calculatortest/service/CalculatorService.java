package pro.sky.calculatortest.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int plus(int x, int y) {
        return x + y;
    }

    public int minus(int x, int y) {
        return x - y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        return x / y;
    }

}
