package testquestions.facade.problem;

import org.junit.jupiter.api.Test;

public class HomeTheaterTest {

    @Test
    public void playMovie() {
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        Lights lights = new Lights();

        System.out.println("\n--- Getting ready to watch a movie ---");
        lights.dim(20);
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(7);
        dvd.on();
        dvd.play("Inception");

        System.out.println("\n--- Shutting movie theater down ---");
        lights.dim(100);
        System.out.println("All systems off.");
    }
}
