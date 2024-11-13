package examples.composition;

import java.time.LocalDate;


public class BikeRace {
    String name;
    LocalDate startDate;
    Double distanceInMiles;

    public BikeRace(String name) {
        this.name = name;
    }

    public BikeRace(String name, LocalDate date, Double distanceInMiles) {
        this.name = name;
        this.startDate = date;
        this.distanceInMiles = distanceInMiles;
    }

    public LocalDate[] getDates() {
        return new LocalDate[]{startDate, startDate};
    }

    public Double getDistanceInMiles() {
        return distanceInMiles;
    }
}
