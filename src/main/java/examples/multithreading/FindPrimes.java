package examples.multithreading;

import java.util.List;
import java.util.concurrent.Callable;

public class FindPrimes implements Callable<List<Integer>> {
    private final int start;
    private final int end;

    public FindPrimes(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public List<Integer> call() {
        return findPrimesInRange(start, end);
    }

    private List<Integer> findPrimesInRange(int start, int end) {
        return java.util.stream.IntStream.rangeClosed(start, end)
                .filter(this::isPrime)
                .boxed()
                .toList();
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
