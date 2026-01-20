package examples.composition;

import java.time.LocalDate;
import java.util.List;
import java.util.SequencedCollection;


public class OneDayBikeRace implements IBikeRace {
    String name;
    LocalDate startDate;
    Double distanceInMiles;

    public OneDayBikeRace(String name) {
        this.name = name;
    }

    public OneDayBikeRace(String name, LocalDate date, Double distanceInMiles) {
        this.name = name;
        this.startDate = date;
        this.distanceInMiles = distanceInMiles;
    }

    public String getDateString() {
        return startDate.toString();
    }

    public Double getDistanceInMiles() {
        return distanceInMiles;
    }

    @Override
    public String toString() {
        return name + " is " + getDistanceInMiles() + " miles long";
    }

    public SequencedCollection<LocalDate> getDates() {
        return List.of(startDate, startDate.plusDays(1));
    }
}
