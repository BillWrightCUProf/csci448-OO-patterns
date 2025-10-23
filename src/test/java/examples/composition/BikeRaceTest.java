package examples.composition;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BikeRaceTest {

    @Test
    void testBikeRace() {
        BikeRace oneDayRace = new BikeRace("Paris-Roubaix", LocalDate.of(2024, 4, 11), 160.0);
        BikeRace tourDeFrance = new StageRace("Tour de France", List.of(
                new BikeRace("Stage 1", LocalDate.of(2024, 7, 1), 120.0),
                new BikeRace("Stage 2", LocalDate.of(2024, 7, 2), 130.0),
                new BikeRace("Stage 3", LocalDate.of(2024, 7, 21), 140.0)
        ));

        List<BikeRace> racesOnMyCalendar = List.of(oneDayRace, tourDeFrance);

        for (BikeRace race : racesOnMyCalendar) {
            System.out.println(race.name + " is " + race.getDistanceInMiles() + " miles long");
        }
    }

    @Test
    void testToString() {
        BikeRace oneDayRace = new BikeRace("Paris-Roubaix", LocalDate.of(2024, 4, 11), 160.0);
        System.out.println(oneDayRace.toString());
    }
}