package pro.sky.homeworks.homework212;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.homeworks.homework212.exceptions.DivideByZeroException;
import pro.sky.homeworks.homework212.services.CalculatorUtils;
import pro.sky.homeworks.homework212.services.CalculatorUtilsImpl;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.homeworks.homework212.Constants.*;

public class CalculatorParamTest {

    private final CalculatorUtils calculatorUtils = new CalculatorUtilsImpl();

    @ParameterizedTest
    @MethodSource("calculatorParams")
    public void shouldSumCorrectly(int num1, int num2) {
        int actual = calculatorUtils.calcSum(num1, num2);
        assertEquals(num1 + num2, actual);
    }

    @ParameterizedTest
    @MethodSource("calculatorParams")
    public void shouldSubtractCorrectly(int num1, int num2) {
        int actual = calculatorUtils.calcSubtract(num1, num2);
        assertEquals(num1 - num2, actual);
    }

    @ParameterizedTest
    @MethodSource("calculatorParams")
    public void shouldMultiplyCorrectly(int num1, int num2) {
        int actual = calculatorUtils.calcMultiply(num1, num2);
        assertEquals(num1 * num2, actual);
    }

    @ParameterizedTest
    @MethodSource("calculatorParams")
    public void shouldDivideCorrectly(int num1, int num2) {
        if (num2 == 0) {
            Throwable thrown = catchThrowable(() -> calculatorUtils.calcDivision(num1, num2));
            assertThat(thrown).isInstanceOf(DivideByZeroException.class);
            assertThat(thrown.getMessage()).isNotBlank();
        } else {
            double actual = calculatorUtils.calcDivision(num1, num2);
            assertEquals((double) num1 / num2, actual);
        }
    }

    private static Stream<Arguments> calculatorParams() {
        return Stream.of(
                Arguments.of(ONE, TWO),
                Arguments.of(ONE, MINUSONE),
                Arguments.of(ONE, ZERO),
                Arguments.of(MINUSONE, MINUSONE)
        );
    }
}
