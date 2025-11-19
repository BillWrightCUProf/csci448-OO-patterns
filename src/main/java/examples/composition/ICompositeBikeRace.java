package examples.composition;

import java.util.List;

public interface ICompositeBikeRace {
    void addStage(IBikeRace stage);
    void removeStage(IBikeRace stage);
    List<IBikeRace> getStages();
}
