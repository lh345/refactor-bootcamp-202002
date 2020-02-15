package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciCalculator {
    public long calculate(int position) {
        long first = 0L;
        long second = 1L;

        for (int i = 0; i < position; i++) {
            long temp = first;
            first = second;
            second = temp + second;
        }
        return first;
    }
}
