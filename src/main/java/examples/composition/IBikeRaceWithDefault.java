package examples.composition;

import java.util.List;

public interface IBikeRaceWithDefault {
    Double getDistanceInMiles();
    String getDateString();

    default void addStage(IBikeRace stage) {
        throw new UnsupportedOperationException("Not supported.");
    }

    default void removeStage(IBikeRace stage) {
        throw new UnsupportedOperationException("Not supported.");
    }

    default List<IBikeRace> getStages() {
        return List.of();
    }
}
