package ooconcepts.dependencyinjection;

import com.google.inject.Inject;

public class DIMain {

    private final Communicator communicator;

    @Inject
    public DIMain(Communicator communicator) {
        this.communicator = communicator;
    }

    public boolean sendMessage(String hello) {
        return communicator.sendMessage(hello);
    }
}
