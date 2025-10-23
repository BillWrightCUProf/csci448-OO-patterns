package examples.multithreading;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PossiblePrime {
    public static BigInteger REPORT_INTERVAL = BigInteger.valueOf(100000000);
    private final BigInteger number;

    public PossiblePrime(BigInteger number) {
        this.number = number;
    }

    public boolean isPrime() {
        if (number.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }
        BigInteger sqrt = number.sqrt();
        for (BigInteger i = BigInteger.TWO; i.compareTo(sqrt) <= 0; i = i.add(BigInteger.ONE)) {
            if (number.mod(i).equals(BigInteger.ZERO)) {
                System.out.println("Divisible by: " + i);
                return false;
            }
            if (i.remainder(REPORT_INTERVAL).equals(BigInteger.ZERO)) {
                System.out.println("Checked up to: " + i);
            }
        }
        System.out.println(number + " is prime");
        return true;
    }

    public void isPrimeWithThreads() {
        if (number.compareTo(BigInteger.ONE) <= 0) {
            return;
        }

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors: " + availableProcessors);
        if (availableProcessors < 2) {
            isPrime(); // Fallback to single-threaded check
            return;
        }

        System.out.println("Using multithreading for prime check");
        // Split the work among available processors
        BigInteger bucketSize = number.sqrt().divide(BigInteger.valueOf(availableProcessors));
        System.out.println("Bucket size: " + bucketSize);
        List<Callable<List<BigInteger>>> tasks = new ArrayList<>();
        try (ExecutorService executor = Executors.newFixedThreadPool(availableProcessors)) {
            for (int i = 0; i < availableProcessors; i++) {
                BigInteger start = BigInteger.TWO.add(bucketSize.multiply(BigInteger.valueOf(i)));
                BigInteger end;
                if (i == availableProcessors - 1) {
                    end = number.sqrt(); // Last thread checks up to sqrt(number)
                } else {
                    end = start.add(bucketSize);
                }
                int finalI = i;
                executor.submit(() -> {
                    for (BigInteger j = start; j.compareTo(end) <= 0; j = j.add(BigInteger.ONE)) {
                        if (number.mod(j).equals(BigInteger.ZERO)) {
                            System.out.println("Divisible by: " + j);
                            return;
                        }
                        if (j.remainder(REPORT_INTERVAL).equals(BigInteger.ZERO)) {
                            System.out.println("Thread " + finalI +": Checked up to: " + j);
                        }
                    }
                });
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
                // Wait for all tasks to complete
            }
        }
    }

    public List<BigInteger> getFactors() {
        if (number.compareTo(BigInteger.ONE) <= 0) {
            return List.of();
        }
        BigInteger sqrt = number.sqrt();
        BigInteger target = number;
        List<BigInteger> factors = new java.util.ArrayList<>();

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors: " + availableProcessors);

        for (BigInteger i = BigInteger.TWO; i.compareTo(sqrt) <= 0; i = i.add(BigInteger.ONE)) {
            if (target.mod(i).equals(BigInteger.ZERO)) {
                factors.add(i);
                System.out.println("Factor found: " + i);
                BigInteger otherFactor = number.divide(i);
                if (!i.equals(otherFactor)) {
                    System.out.println("Factor found: " + otherFactor);
                    factors.add(otherFactor);
                }
                target = otherFactor;
            }
        }
        return factors;
    }


//    public List<BigInteger> getFactorsWithThreads() {
//        if (number.compareTo(BigInteger.ONE) <= 0) {
//            return List.of();
//        }
//        BigInteger sqrt = number.sqrt();
//        BigInteger target = number;
//        List<Future<BigInteger>> factors = new ArrayList<>();
//
//        for (BigInteger i = BigInteger.TWO; i.compareTo(sqrt) <= 0; i = i.add(BigInteger.ONE)) {
//            if (target.mod(i).equals(BigInteger.ZERO)) {
//                factors.add(i);
//                System.out.println("Factor found: " + i);
//                BigInteger otherFactor = number.divide(i);
//                if (!i.equals(otherFactor)) {
//                    System.out.println("Factor found: " + otherFactor);
//                    factors.add(otherFactor);
//                }
//                target = otherFactor;
//            }
//        }
//        return factors;
//    }

}
