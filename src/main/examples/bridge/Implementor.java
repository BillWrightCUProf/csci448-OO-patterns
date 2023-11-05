package examples.bridge;

public class Implementor {
    double add(double summand_1, double summand_2) {
        return summand_1 + summand_2;
    }
    double subtract(double minuend, double subtrahend) {
        return minuend - subtrahend;
    }
    double multiply(double factor_1, double factor_2) {
        return factor_1 * factor_2;
    }
    double divide(double dividend, double divisor) {
        return dividend / divisor;
    }
}
