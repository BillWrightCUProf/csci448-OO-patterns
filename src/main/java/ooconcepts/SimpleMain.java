package ooconcepts;

public class SimpleMain {

    public SimpleMain(String[] defaultArgs) {
        ProcessArgs processArgs = new ProcessArgs();
        processArgs.process(defaultArgs);
    }

    public static void main(String[] args) {
        System.out.println("Hello, world!");

        ProcessArgs processArgs = new ProcessArgs();
        processArgs.process(args);
    }
}
