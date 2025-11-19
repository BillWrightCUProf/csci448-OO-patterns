package examples.composition;

import java.time.LocalDate;
import java.util.List;

public class StageRace extends BikeRaceSuperclass {
    List<OneDayBikeRace> stages;

    public StageRace(String name, List<OneDayBikeRace> stages) {
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
        return stages.stream().mapToDouble(OneDayBikeRace::getDistanceInMiles).sum();
    }
}
