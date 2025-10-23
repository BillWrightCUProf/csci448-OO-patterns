package examples.multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindNumOfPrimesTest {

    @Test
    void testFindNumOfPrimes() throws Exception {
        FindNumOfPrimes findNumOfPrimes = new FindNumOfPrimes(1, 10);
        Integer result = findNumOfPrimes.call();
        assertEquals(4, result.intValue(), "There should be 4 primes between 1 and 10");
    }
}