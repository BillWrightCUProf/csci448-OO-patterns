package ooconcepts;

public class ProcessArgs {

    public void process(String[] args) {
        System.out.println("Hello, processing args...");

        for (String arg : args) {
            System.out.println("arg: " + arg);
        }
    }
}
