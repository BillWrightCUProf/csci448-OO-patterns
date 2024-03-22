package examples.composition;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BikeRaceTest {

    @Test
    void testBikeRace() {
        BikeRace oneDayRace = new BikeRace("Paris-Roubaix", new Date(4, 11, 2024), 160.0);
        BikeRace tourDeFrance = new StageRace("Tour de France", List.of(
                new BikeRace("Stage 1", new Date(1, 7, 2024), 120.0),
                new BikeRace("Stage 2", new Date(2, 7, 2024), 130.0),
                new BikeRace("Stage 3", new Date(3, 7, 2024), 140.0)
        ));

        List<BikeRace> racesOnMyCalendar = List.of(oneDayRace, tourDeFrance);

        for (BikeRace race : racesOnMyCalendar) {
            System.out.println(race.name + " is " + race.getDistanceInMiles() + " miles long");
        }
    }
}