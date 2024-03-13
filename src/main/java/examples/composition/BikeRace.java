package examples.composition;

import java.util.Date;

public class BikeRace {
    String name;
    Date startDate;
    Double distanceInMiles;

    public BikeRace(String name) {
        this.name = name;
    }

    public BikeRace(String name, Date date, Double distanceInMiles) {
        this.name = name;
        this.startDate = date;
        this.distanceInMiles = distanceInMiles;
    }

    public Date[] getDates() {
        return new Date[]{startDate, startDate};
    }

    public Double getDistanceInMiles() {
        return distanceInMiles;
    }
}
