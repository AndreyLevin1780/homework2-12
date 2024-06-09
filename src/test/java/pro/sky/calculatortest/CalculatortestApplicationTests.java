package pro.sky.calculatortest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.calculatortest.exception.DivisionByZeroException;
import pro.sky.calculatortest.service.CalculatorService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatortestApplicationTests {

	CalculatorService calculatorService = new CalculatorService();
	@Test
	void plus() {

		int result = calculatorService.plus(10, 20);
		assertEquals(30, result);

		result = calculatorService.plus(10, -20);
		assertEquals(-10, result);
	}

	@Test
	void minus() {
		int result = calculatorService.minus(30, 10);
		assertEquals(20, result);

		result = calculatorService.minus(130, 170);
		assertEquals(-40, result);
	}

	@Test
	void multiply() {
		int result = calculatorService.multiply(-2, 30);
		assertEquals(-60, result);

		result = calculatorService.multiply(2, 40);
		assertEquals(80, result);
	}

	@Test
	void divide() {
		int result = calculatorService.divide(20, 10);
		assertEquals(2, result);

		result = calculatorService.divide(-2000, -100);
		assertEquals(20, result);
	}

	@Test
	void divideNegativeTest() {
		assertThrows(ArithmeticException.class, () -> calculatorService.divide(10,0));
	}

}
