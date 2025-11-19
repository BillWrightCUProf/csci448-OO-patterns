package examples.composition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StageRaceViaInterface implements IBikeRace, ICompositeBikeRace {
    String name;
    List<IBikeRace> stages;

    public StageRaceViaInterface(String name, List<IBikeRace> stages) {
        this.name = name;
        this.stages = stages;
    }


    @Override
    public String getDateString() {
        return stages.getFirst().getDateString() + " - " + stages.getLast().getDateString();
    }

    @Override
    public Double getDistanceInMiles() {
        return stages.stream().mapToDouble(IBikeRace::getDistanceInMiles).sum();
    }

    @Override
    public void addStage(IBikeRace stage) {
        stages.add(stage);
    }

    @Override
    public void removeStage(IBikeRace stage) {
        stages.remove(stage);
    }

    @Override
    public List<IBikeRace> getStages() {
        return new ArrayList<>(stages);
    }
}
