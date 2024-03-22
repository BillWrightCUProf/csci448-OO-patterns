package ooconcepts.dependencyinjection;

public class DefaultCommunicatorImpl implements Communicator {
    @Override
    public boolean sendMessage(String message) {
        System.out.println("Message sent: " + message);
        return true;
    }
}
