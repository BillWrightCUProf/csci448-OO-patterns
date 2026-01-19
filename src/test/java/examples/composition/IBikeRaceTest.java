package examples.composition;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class IBikeRaceTest {

    @Test
    void testBikeRace() {
        BikeRaceSuperclass oneDayRace = new BikeRaceSuperclass("Paris-Roubaix", LocalDate.of(2024, 4, 11), 160.0);
        BikeRaceSuperclass tourDeFrance = new StageRace("Tour de France", List.of(
                new OneDayBikeRace("Stage 1", LocalDate.of(2024, 7, 1), 120.0),
                new OneDayBikeRace("Stage 2", LocalDate.of(2024, 7, 2), 130.0),
                new OneDayBikeRace("Stage 3", LocalDate.of(2024, 7, 21), 140.0)
        ));

        List<BikeRaceSuperclass> racesOnMyCalendar = List.of(oneDayRace, tourDeFrance);

        for (BikeRaceSuperclass race : racesOnMyCalendar) {
            System.out.println(race.name + " is " + race.getDistanceInMiles() + " miles long");
        }
    }

    @Test
    void testToString() {
        OneDayBikeRace oneDayRace = new OneDayBikeRace("Paris-Roubaix", LocalDate.of(2024, 4, 11), 160.0);
        System.out.println(oneDayRace.toString());
    }

    @Test
    void testInterfaceComposite() {

    }
}