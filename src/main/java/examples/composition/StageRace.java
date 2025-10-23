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
    public List<LocalDate> getDates() {
        return List.of(
                stages.getFirst().getDates().getFirst(),
                stages.getLast().getDates().getLast()
        );
    }

    @Override
    public Double getDistanceInMiles() {
        return stages.stream().mapToDouble(BikeRace::getDistanceInMiles).sum();
    }
}
