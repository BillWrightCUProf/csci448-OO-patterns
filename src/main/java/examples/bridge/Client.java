package examples.bridge;

public class Client {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("30 * 12 = " + calculator.multiply(30, 12));
    }
}
