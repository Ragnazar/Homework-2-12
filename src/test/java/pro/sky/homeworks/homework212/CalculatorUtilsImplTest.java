package pro.sky.homeworks.homework212;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.homeworks.homework212.exceptions.DivideByZeroException;
import pro.sky.homeworks.homework212.services.CalculatorUtils;
import pro.sky.homeworks.homework212.services.CalculatorUtilsImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.homeworks.homework212.Constants.*;

@SpringBootTest
class CalculatorUtilsImplTest {

    CalculatorUtils calc = new CalculatorUtilsImpl();

    @Test
    public void shouldSumAndGetTwo() {

        int actual = calc.calcSum(ONE, ONE);
        assertEquals(ONE + ONE, actual);
    }

    @Test
    public void shouldSubtractAndGetTwo() {
        int actual = calc.calcSubtract(ONE, MINUSONE);
        assertEquals(ONE - MINUSONE, actual);
    }


    @Test
    public void shouldSubtractAndGetMinusTwo() {
        int actual = calc.calcSubtract(MINUSONE, ONE);
        assertEquals(MINUSONE - ONE, actual);
    }

    @Test
    public void shouldMultiplyAndGetMinusTwo() {
        int actual = calc.calcMultiply(TWO, MINUSONE);
        assertEquals(TWO * MINUSONE, actual);
    }

    @Test
    public void shouldMultiplyAndGetZero() {
        int actual = calc.calcMultiply(ZERO, MINUSONE);
        assertEquals(ZERO * MINUSONE, actual);
    }

    @Test
    public void shouldSumAndGetZero() {
        int actual = calc.calcSum(ONE, MINUSONE);
        assertEquals(ONE + MINUSONE, actual);
    }

    @Test
    public void shouldDivideAndGetOne() {
        double actual = calc.calcDivision(TWO, TWO);
        assertEquals((double) TWO / TWO, actual);
    }

    @Test
    public void shouldDivideAndGetMinusOne() {
        double actual = calc.calcDivision(MINUSONE, ONE);
        assertEquals((double) MINUSONE / ONE, actual);
    }

    @Test
    public void shouldDivideByZeroAndGetAnException() {
        Throwable thrown = catchThrowable(() -> calc.calcDivision(ONE, ZERO));
        assertThat(thrown).isInstanceOf(DivideByZeroException.class);
        assertThat(thrown.getMessage()).isNotBlank();
    }

    @Test
    public void shouldShowAGreetingsMessage() {
        assertThat(calc.hello()).isEqualTo("Добро пожаловать в калькулятор");
    }
}
