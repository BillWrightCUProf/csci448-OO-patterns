package examples.composition;

import java.time.LocalDate;
import java.util.List;


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

    public List<LocalDate> getDates() {
        return List.of(startDate, startDate);
    }

    public Double getDistanceInMiles() {
        return distanceInMiles;
    }

    @Override
    public String toString() {
        return name + " is " + getDistanceInMiles() + " miles long";
    }
}
