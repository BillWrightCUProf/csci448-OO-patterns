package examples.bridge;

public class FFT extends Calculator {
    @Override
    public double multiply(double factor_1, double factor_2) {
        // assume this is some special FFT multiplication
        return factor_1 * factor_2;
    }
}
