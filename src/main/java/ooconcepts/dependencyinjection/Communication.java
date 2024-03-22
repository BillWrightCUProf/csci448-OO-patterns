package ooconcepts.dependencyinjection;

import com.google.inject.Inject;

import java.util.logging.Logger;

public class Communication {

    @Inject
    private Logger logger;
    @Inject
    private Communicator communicator;

    public Communication() {
        System.out.println("Message logging disabled");
    }

    public boolean sendMessage(String message) {
        return communicator.sendMessage(message);
    }

}
