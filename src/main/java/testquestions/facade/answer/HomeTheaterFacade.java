package testquestions.facade.answer;

import testquestions.facade.problem.Amplifier;
import testquestions.facade.problem.DVDPlayer;
import testquestions.facade.problem.Lights;
import testquestions.facade.problem.Projector;

public class HomeTheaterFacade {
    private final Amplifier amp;
    private final DVDPlayer dvd;
    private final Projector projector;
    private final Lights lights;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector, Lights lights) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("\n--- Getting ready to watch a movie ---");
        lights.dim(20);
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(7);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("\n--- Shutting movie theater down ---");
        lights.dim(100);
        System.out.println("All systems off.");
    }
}
