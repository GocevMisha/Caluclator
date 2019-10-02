package calculator;

import calculator.exception.DivideByZeroException;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class ExecutorTest {

    private Random random = new Random();
    private int COUNT_ADVANCED_TEST = 100000;

    @Test
    public void executeAdditionalTest() {
        for (int i = 0; i < COUNT_ADVANCED_TEST; i++) {
            double x = getRandomNumber();
            double y = getRandomNumber();
            assertThat(Executor.execute(x, y, '+'), equalTo(x + y));
        }
    }

    @Test
    public void executeSubtractionTest() {
        for (int i = 0; i < COUNT_ADVANCED_TEST; i++) {
            double x = getRandomNumber();
            double y = getRandomNumber();
            assertThat(Executor.execute(x, y, '-'), equalTo(x - y));
        }
    }

    @Test
    public void executeMultiplicationTest() {
        for (int i = 0; i < COUNT_ADVANCED_TEST; i++) {
            double x = getRandomNumber();
            double y = getRandomNumber();
            assertThat(Executor.execute(x, y, '*'), equalTo(x * y));
        }
    }

    @Test
    public void executeDivisionTest() {
        for (int i = 0; i < COUNT_ADVANCED_TEST; i++) {
            double x = getRandomNumber();
            double y = getRandomNumber();
            assertThat(Executor.execute(x, y, '/'), equalTo(x / y));
        }
    }

    @Test
    public void executeExponentiationTest() {
        for (int i = 0; i < COUNT_ADVANCED_TEST; i++) {
            double x = getRandomNumber();
            double y = getRandomNumber();
            assertThat(Executor.execute(x, y, '^'), equalTo(Math.pow(x, y)));
        }
    }

    @Test(expected = DivideByZeroException.class)
    public void explicitDivisionByZeroTest() {
        Executor.execute(getRandomNumber(), 0, '/');
    }

    @Test(expected = DivideByZeroException.class)
    public void implicitDivisionByZeroTest() {
        Executor.execute(0, -1, '^');
    }

    private double getRandomNumber() {
        double notZeroNumber = 0;
        while (notZeroNumber == 0) {
            notZeroNumber = Math.round(random.nextDouble() * 10000) / 100.0;
        }
        return notZeroNumber;
    }
}