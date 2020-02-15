package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciCalculatorTest {
    @Test
    void should_return_1_when_calculate_fib_given_position_1() {
        int position = 1;
        FibonacciCalculator calculator = new FibonacciCalculator();
        long result = calculator.calculate(position);

        assertEquals(1, result);
    }

    @Test
    void should_return_1_when_calculate_fib_given_position_2() {
        int position = 2;
        FibonacciCalculator calculator = new FibonacciCalculator();
        long result = calculator.calculate(position);

        assertEquals(1, result);
    }

    @Test
    void should_return_2_when_calculate_fib_given_position_3() {
        int position = 3;
        FibonacciCalculator calculator = new FibonacciCalculator();
        long result = calculator.calculate(position);

        assertEquals(2, result);
    }
}
