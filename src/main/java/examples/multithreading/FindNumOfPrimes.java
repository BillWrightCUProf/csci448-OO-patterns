package examples.multithreading;

import java.util.concurrent.Callable;

public class FindNumOfPrimes implements Callable<Integer> {
    private final int start;
    private final int end;

    public FindNumOfPrimes(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
