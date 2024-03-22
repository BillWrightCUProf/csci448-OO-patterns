package ooconcepts.dependencyinjection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommunicationTest {

    @Test
    void testInjection() {
        Injector injector = Guice.createInjector(new BasicModule());
        Communication comms = injector.getInstance(Communication.class);
        assertTrue(comms.sendMessage("Hello"));

        DIMain main = injector.getInstance(DIMain.class);
        assertTrue(main.sendMessage("Hello"));
    }

}