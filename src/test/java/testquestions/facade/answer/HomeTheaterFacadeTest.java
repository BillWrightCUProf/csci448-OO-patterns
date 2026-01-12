package testquestions.facade.answer;

import org.junit.jupiter.api.Test;
import testquestions.facade.problem.Amplifier;
import testquestions.facade.problem.DVDPlayer;
import testquestions.facade.problem.Lights;
import testquestions.facade.problem.Projector;

import static org.junit.jupiter.api.Assertions.*;

class HomeTheaterFacadeTest {

    @Test
    public void playMovie() {
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        Lights lights = new Lights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector, lights);
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }

}