package examples.multithreading;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

class FindPrimesTest {
    int largeNumber = 100_000_000;
    int availableProcessors;

    FindPrimesTest() {
        availableProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processors: " + availableProcessors);
    }

    @Test
    void testFindPrimes() throws Exception {
        FindPrimes findPrimes = new FindPrimes(1, largeNumber);
        var result = findPrimes.call();
        assertTrue(!result.isEmpty(), "There should be some primes found between 1 and " + largeNumber);
    }

    @Test
    void testUseThreads() throws InterruptedException {
        List<Callable<List<Integer>>> tasks = createCallables();

        System.out.println("Starting up threads...");
        List<Future<List<Integer>>> futures = Executors.newFixedThreadPool(availableProcessors).invokeAll(tasks);
        System.out.println("Done with all threads...");

        int totalPrimes = 0;
        for (Future<List<Integer>> future : futures) {
            try {
                List<Integer> primes = future.get();
                totalPrimes += primes.size();
                System.out.println("Found " + primes.size() + " primes in range.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total primes: " + totalPrimes);
    }

    private List<Callable<List<Integer>>> createCallables() {
        List<Callable<List<Integer>>> tasks = new ArrayList<>();
        int range = largeNumber / availableProcessors;
        for (int i = 0; i < availableProcessors; i++) {
            int start = i * range + 1;
            int end = (i == availableProcessors - 1) ? largeNumber : (i + 1) * range;
            tasks.add(new FindPrimes(start, end));
        }
        return tasks;
    }

    @Test
    void testUsingThreadsAndAStream() throws InterruptedException, ExecutionException {
        List<Callable<List<Integer>>> tasks = createCallables();

        int numPrimes = Executors.newFixedThreadPool(availableProcessors)
                .invokeAll(tasks)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (InterruptedException | ExecutionException e) {
                        return List.<Integer>of(); // Return empty list on error
                    }
                })
                .reduce(0, (count, primes) -> count + primes.size(), Integer::sum);

        System.out.println("Total primes: " + numPrimes);
    }

}