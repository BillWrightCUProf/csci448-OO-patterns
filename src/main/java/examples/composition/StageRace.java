package examples.composition;

import java.util.Date;
import java.util.List;

public class StageRace extends BikeRace {
    List<BikeRace> stages;

    public StageRace(String name, List<BikeRace> stages) {
        super(name);
        this.stages = stages;
    }


    @Override
    public Date[] getDates() {
        Date[] dates = new Date[2];
        dates[0] = stages.get(0).getDates()[0];
        dates[1] = stages.get(stages.size() - 1).getDates()[1];
        return dates;
    }
    @Override
    public Double getDistanceInMiles() {
        return stages.stream().mapToDouble(BikeRace::getDistanceInMiles).sum();
    }
}
