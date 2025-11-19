package examples.composition;

import java.time.LocalDate;
import java.util.List;

public class BikeRaceSuperclass {
    String name;
    LocalDate date;
    Double distanceInMiles;

    public BikeRaceSuperclass(String name) {
        this.name = name;
    }

    public BikeRaceSuperclass(String name, LocalDate date, Double distanceInMiles) {
        this.name = name;
        this.date = date;
        this.distanceInMiles = distanceInMiles;
    }

    public String getDateString() {
        return date.toString();
    }

    public Double getDistanceInMiles() {
        return distanceInMiles;
    }

    public String displayInfo() {
        return name + " is " + getDistanceInMiles() + " miles long and held on " + getDateString();
    }

    @Override
    public String toString() {
        return name + " is " + getDistanceInMiles() + " miles long";
    }
}
