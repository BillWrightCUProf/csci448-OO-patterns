package examples.composition;

import java.time.LocalDate;
import java.util.List;

public class StageRace extends BikeRace {
    List<BikeRace> stages;

    public StageRace(String name, List<BikeRace> stages) {
        super(name);
        this.stages = stages;
    }


    @Override
    public LocalDate[] getDates() {
        LocalDate[] dates = new LocalDate[2];
        dates[0] = stages.getFirst().getDates()[0];
        dates[1] = stages.getLast().getDates()[1];
        return dates;
    }
    @Override
    public Double getDistanceInMiles() {
        return stages.stream().mapToDouble(BikeRace::getDistanceInMiles).sum();
    }
}
