package ooconcepts;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("Hello, world!");

        ProcessArgs processArgs = new ProcessArgs();
        processArgs.process(args);
    }
}
