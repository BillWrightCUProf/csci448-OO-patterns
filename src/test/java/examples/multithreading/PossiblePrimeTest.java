package examples.multithreading;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class PossiblePrimeTest {

    @Test
    void testNoThreads() {
//        BigInteger bigInteger = new BigInteger("9704279911");
        BigInteger bigInteger = new BigInteger("9008548009007");
        PossiblePrime prime = new PossiblePrime(bigInteger);
        assertTrue(prime.isPrime(), bigInteger + " should be prime");
    }

    @Test
    void testNoThreadsBigInt() {
        BigInteger bigInteger = new BigInteger("37107287533902102798797998220837590246510135740253");
        PossiblePrime prime = new PossiblePrime(bigInteger);
        assertFalse(prime.isPrime(), bigInteger + "should NOT be prime");
    }

    @Test
    void testNoThreadsBigInt2() {
        BigInteger bigInteger = new BigInteger("1069682546379420662980628371889235809931107977522374618009949337");
        PossiblePrime prime = new PossiblePrime(bigInteger);
        assertFalse(prime.isPrime(), bigInteger + "should NOT be prime");
    }

    @Test
    void testNoThreadsFindFactors() {
        BigInteger bigInteger = new BigInteger("371072875339026514250053");
        PossiblePrime prime = new PossiblePrime(bigInteger);
        System.out.println("The factors of " + bigInteger + " are: " + prime.getFactors());
    }

    @Test
    void testWithThreadsFindFactors() {
        BigInteger bigInteger = new BigInteger("371072875339026514250053");
        PossiblePrime prime = new PossiblePrime(bigInteger);
        prime.isPrimeWithThreads();
    }
}