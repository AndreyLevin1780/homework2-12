package pro.sky.calculatortest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.calculatortest.service.CalculatorService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorServiceParameterizedTests {

    CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("ProvideParamsForPlus")
    void plus(int x, int y, int expected) {

        int actual = calculatorService.plus(x, y);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> ProvideParamsForPlus() {
        return Stream.of(
                Arguments.of(2, 3, 5),
                Arguments.of(-10, 20, 10),
                Arguments.of(100, 200, 300)
        );
    }

    @ParameterizedTest
    @MethodSource("ProvideParamsForMinus")
    void minus(int x, int y, int expected) {

        int actual = calculatorService.minus(x, y);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> ProvideParamsForMinus() {
        return Stream.of(
                Arguments.of(2, 3, -1),
                Arguments.of(-10, 20, -30),
                Arguments.of(100, 200, -100)
        );
    }

    @ParameterizedTest
    @MethodSource("ProvideParamsForMultiply")
    void multiply(int x, int y, int expected) {

        int actual = calculatorService.multiply(x, y);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> ProvideParamsForMultiply() {
        return Stream.of(
                Arguments.of(2, 3, 6),
                Arguments.of(-10, 20, -200),
                Arguments.of(100, 200, 20000)
        );
    }

    @ParameterizedTest
    @MethodSource("ProvideParamsForDivide")
    void divide(int x, int y, int expected) {

        int actual = calculatorService.divide(x, y);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> ProvideParamsForDivide() {
        return Stream.of(
                Arguments.of(3, 3, 1),
                Arguments.of(100, 20, 5),
                Arguments.of(1000, -200, -5)
        );
    }

    @ParameterizedTest
    @MethodSource("ProvideParamsForDivideNegative")
    void divideNegative(int x, int y) {

        assertThrows(ArithmeticException.class, () -> calculatorService.divide(x, y));
    }

    static Stream<Arguments> ProvideParamsForDivideNegative() {
        return Stream.of(
                Arguments.of(3, 0),
                Arguments.of(-100, 0),
                Arguments.of(1000, 0)
        );
    }
}
